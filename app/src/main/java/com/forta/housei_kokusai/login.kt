package com.forta.housei_kokusai


import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


const val RC_SIGN_IN = 123
const val RC_ONE_TAP = 124

val navController: NavController? = null

class login : Fragment() {


    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private lateinit var oneTapClient: SignInClient
    private lateinit var signInRequest: BeginSignInRequest

    // Control whether user declined One Tap UI
    private var userDeclinedOneTap = true

    // UI elements
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPassword: TextInputLayout

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

        // Check if user is signed in (non-null) and update UI accordingly.

        updateUI(currentUser)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }







    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        //inputEmail = view.findViewById(R.id.tilEmail)
        //inputPassword = view.findViewById(R.id.tilPassword)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.your_web_client_id))
            .requestEmail()
            .build()

        // Initialize lateinit vars
        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        auth = Firebase.auth

        oneTapClient = Identity.getSignInClient(requireContext())
        signInRequest = BeginSignInRequest.builder()
            .setPasswordRequestOptions(BeginSignInRequest.PasswordRequestOptions.builder()
                .setSupported(true)
                .build())
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setServerClientId(getString(R.string.your_web_client_id))
                    // Only show accounts previously used to sign in.
                    .setFilterByAuthorizedAccounts(true)
                    .build())
            .build()

        // Click listeners for the buttons
        view.findViewById<SignInButton>(R.id.btnGoogleSignin).setOnClickListener {
            signIn()
        }
        /*
        view.findViewById<Button>(R.id.btnSignIn).setOnClickListener {
            val email = inputEmail.editText?.text.toString()
            val password = inputPassword.editText?.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                signInWithPassword(email, password)
            }
        }
        view.findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            val email = inputEmail.editText?.text.toString()
            val password = inputPassword.editText?.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                signUpWithPassword(email, password)
            }
        }*/
    }

    private fun updateUI(currentUser: FirebaseUser?) {



        //??????????????????????????????
        val launch_count = requireActivity().getSharedPreferences("???????????????" , Context.MODE_PRIVATE)
        var countTime = launch_count.getInt("Count" , 0)
        countTime = countTime++
        launch_count.edit().putInt("Count",countTime).apply()


        //?????????????????????????????????
        if(countTime == 1 && currentUser != null){

            findNavController().navigate(R.id.action_login2_to_firsttime)



        }else if (currentUser != null) {
            // If currentUser != null, let's go to the next screen
            findNavController().navigate(R.id.action_login2_to_tourokuManday)
        } else {
            // If the user hasn't already declined to use One Tap sign-in
            if (!userDeclinedOneTap) {
                // Check if the user has saved credentials on our app
                // and display the One Tap UI
                oneTapClient.beginSignIn(signInRequest)
                    .addOnSuccessListener { result ->
                        // This listener will be triggered if the
                        // user does have saved credentials
                        try {
                            startIntentSenderForResult(
                                result.pendingIntent.intentSender, RC_ONE_TAP,
                                null, 0, 0, 0, null)
                        } catch (e: IntentSender.SendIntentException) {
                            Toast.makeText( requireContext(), "Couldn't start One Tap UI: ${e.localizedMessage}" , Toast.LENGTH_SHORT).show()
                        }

                    }.addOnFailureListener { e ->
                        // No saved credentials found. Launch the One Tap sign-up flow, or
                        // do nothing and continue presenting the signed-out UI.
                        Toast.makeText(requireContext() , "No saved credentials: ${e.localizedMessage}" , Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    // Sign in to an existing password account
    private fun signInWithPassword(email: String, password: String) {
        Toast.makeText( requireContext(), "Signing in with email '$email' and '$password'" , Toast.LENGTH_SHORT).show()
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { authResult ->
                val currentUser = authResult.user
                updateUI(currentUser)
            }
            .addOnFailureListener {
                // If sign in fails, display a message to the user.
                Toast.makeText(requireContext() , "signInWithEmail:failure" , Toast.LENGTH_SHORT).show()
                Toast.makeText(requireContext(), "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
    }

    // Create a new password account
    private fun signUpWithPassword(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { authResult ->
                val currentUser = authResult.user
                updateUI(currentUser)
            }
            .addOnFailureListener {
                // If sign in fails, display a message to the user.
                Toast.makeText(requireContext() , "createUserWithEmail:failure" , Toast.LENGTH_SHORT).show()
                Toast.makeText(requireContext(), "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
            }
    }

    private fun firebaseAuthWithGoogle(googleIdToken: String) {
        val credential = GoogleAuthProvider.getCredential(googleIdToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(requireContext() , "signInWithCredential:success" , Toast.LENGTH_SHORT).show()
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(requireContext() , "signInWithCredential:failure" , Toast.LENGTH_SHORT).show()
                    Snackbar.make(requireView(),
                        "Authentication Failed.",
                        Snackbar.LENGTH_SHORT).show()
                    updateUI(null)
                }

                // ...
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
            RC_SIGN_IN -> {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)!!
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                    Toast.makeText(requireContext() , "Google sign in failed" , Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_login2_to_tourokuManday)////////////////////////////////////////////////////////////////////////////////////
                    // ...
                }
            }
            // Result returned from launching the Intent from startIntentSenderForResult(...)
            RC_ONE_TAP -> {
                try {
                    val credential = oneTapClient.getSignInCredentialFromIntent(data)
                    // This credential contains a googleIdToken which
                    // we can use to authenticate with FirebaseAuth
                    credential.googleIdToken?.let {
                        firebaseAuthWithGoogle(it)
                    }
                    // If the user used email/password, the credential
                    // should provide the user's email and password
                    credential.password?.let { password ->
                        signInWithPassword(credential.id, password)
                    }
                } catch (e: ApiException) {
                    when (e.statusCode) {
                        CommonStatusCodes.CANCELED -> {
                            // The user closed the dialog
                            userDeclinedOneTap = true
                        }
                        CommonStatusCodes.NETWORK_ERROR -> {
                            // No Internet connection ?
                        }
                        else -> {
                            // Some other error
                        }
                    }
                }
            }
        }
    }
}