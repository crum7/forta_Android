package com.forta.housei_kokusai

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class firsttime_3: Fragment() ,View.OnClickListener {


    var navController: NavController? = null

    private lateinit var database: DatabaseReference
    val db=Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firsttime_3 , container , false)
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)


        lateinit var auth: FirebaseAuth


        //val ref = database.getReference()
        auth=Firebase.auth


        val gifView2=view.findViewById<ImageView>(R.id.gifView2)




        val gifMovie2: Int=R.raw.tomodati




        Glide.with(this).load(gifMovie2).into(gifView2)



        //ボタンで画面遷移
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button_first_3).setOnClickListener(this)
        //アプリの起動回数把握
        val launch_count = requireActivity().getSharedPreferences("ファイル名" , Context.MODE_PRIVATE)
        var countTime = launch_count.getInt("Count" , 0)
        countTime++

        launch_count.edit().putInt("Count",countTime).apply()







    }


    //なんのボタンが押されたら、どの処理をするか。
    override fun onClick(v: View?) {
        when(v!!.id){

            R.id.button_first_3-> navController!!.navigate(R.id.action_firsttime_3_to_firsttime_4)







        }

    }
}

