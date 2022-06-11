package com.example.housei_kokusai

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import io.grpc.Context

class MyAdapter (private val context: Activity, private val arrayList: ArrayList<admit_friends_name>) :
    ArrayAdapter<admit_friends_name>(context,R.layout.list_item_original,arrayList){

    override fun getView(position: Int , convertView: View? , parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item_original,null)

        val imageView: ImageView = view.findViewById(R.id.image)
        val username: TextView = view.findViewById(R.id.name)


        //imageView.setImageResource(arrayList[position].image)
        username.text = arrayList[position].name




        return view
    }

}