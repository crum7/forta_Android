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


class firsttime_2 : Fragment() ,View.OnClickListener {


    var navController: NavController? = null

    private lateinit var database: DatabaseReference
    val db=Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firsttime_2 , container , false)
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)


        lateinit var auth: FirebaseAuth


        //val ref = database.getReference()
        auth=Firebase.auth









        //gif画像の表示
        val gifView1=view.findViewById<ImageView>(R.id.gifView1)



        val gifMovie1: Int=R.raw.touroku



        // gif画像のセット
        Glide.with(this).load(gifMovie1).into(gifView1)



        //ボタンで画面遷移
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.button_first_2).setOnClickListener(this)
        //アプリの起動回数把握
        val launch_count = requireActivity().getSharedPreferences("ファイル名" , Context.MODE_PRIVATE)
        var countTime = launch_count.getInt("Count" , 0)
        countTime++

        launch_count.edit().putInt("Count",countTime).apply()







    }


    //なんのボタンが押されたら、どの処理をするか。
    override fun onClick(v: View?) {
        when(v!!.id){

            R.id.button_first_2-> navController!!.navigate(R.id.action_firsttime_2_to_firsttime_3)







        }

    }
}

