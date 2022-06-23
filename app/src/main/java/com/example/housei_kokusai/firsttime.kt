package com.example.housei_kokusai

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class firsttime : Fragment() ,View.OnClickListener {


    var navController: NavController? = null

    private lateinit var database: DatabaseReference
    val db=Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firsttime , container , false)
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)


        lateinit var auth: FirebaseAuth


        //val ref = database.getReference()
        auth=Firebase.auth

        //自分の名前
        val user_name=Firebase.auth.currentUser?.displayName.toString()


        //名前変更
        val button=view.findViewById<Button>(R.id.save_button_name_first)
        val changeName=requireActivity().findViewById<EditText>(R.id.changeName_first)



        button.setOnClickListener {

            val willName=changeName.text.toString()


            val custom_name=hashMapOf(
                "display_name" to willName ,

                )

            val custom_name_others=hashMapOf(
                "name" to willName ,

                )


            //自分のdisplay_nameの設定
            db.collection("users_profile").document("$user_name")
                .set(custom_name as Map<String , Any>)
        }




        //gif画像の表示
            val gifView1=view.findViewById<ImageView>(R.id.gifView1)
            val gifView2=view.findViewById<ImageView>(R.id.gifView2)
            val gifView3=view.findViewById<ImageView>(R.id.gifView3)


        val gifMovie1: Int=R.raw.test
        val gifMovie2: Int=R.raw.test
        val gifMovie3: Int=R.raw.test


        // gif画像のセット
        Glide.with(this).load(gifMovie1).into(gifView1)
        Glide.with(this).load(gifMovie2).into(gifView2)
        Glide.with(this).load(gifMovie3).into(gifView3)


        //ボタンで画面遷移
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button_first).setOnClickListener(this)
        //アプリの起動回数把握
        val launch_count = requireActivity().getSharedPreferences("ファイル名" , Context.MODE_PRIVATE)
        var countTime = launch_count.getInt("Count" , 0)
        countTime++

        launch_count.edit().putInt("Count",countTime).apply()







    }


    //なんのボタンが押されたら、どの処理をするか。
    override fun onClick(v: View?) {
        when(v!!.id){

            R.id.button_first-> navController!!.navigate(R.id.action_firsttime_to_tourokuManday)







        }

    }
}

