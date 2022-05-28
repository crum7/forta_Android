package com.example.housei_kokusai


import android.app.AlertDialog
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



//Fragmentを継承したclassを作る　これがなきゃ始まらない
class friendskennsaku : Fragment(){

    var navController: NavController? = null
    val db = Firebase.firestore


    override fun onCreateView(
        inflater: LayoutInflater ,
        container: ViewGroup? ,
        savedInstanceState: Bundle?


    ): View? {
//まずは、こいつでfragment_homeを表示する
        return inflater.inflate(R.layout.fragment_friendskennsaku , container , false)


    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        navController = Navigation.findNavController(view)
        val user_name = Firebase.auth.currentUser?.displayName
        val list = requireActivity().findViewById<ListView>(R.id.list_view_kennsaku)

        var display_name = arrayListOf("")
        var real_name = arrayListOf("")
        var name = arrayListOf("")
        var kore = ""


        db.collection("users_profile")
            .get()
            .addOnSuccessListener { result ->

                for (document in result) {
                    Log.d(TAG , "${document.id} => ${document.data}")

                    name.add(document.data.toString())
                    kore = document.data.toString()
                    //Toast.makeText(context , name , Toast.LENGTH_SHORT).show()

                    val tokusyu = kore.replace(Regex("[={}*]") , "").replace("display_name","")


                    //データ読み取り


                    //配列にする
                    display_name.add(tokusyu)
                    real_name.add(document.id)





                }
                //ListViewで表示
                val adapter = ArrayAdapter<String>(
                    requireContext() ,
                    android.R.layout.simple_list_item_1 ,
                    display_name//本番環境ではhyouzi_array
                )

                list.setAdapter(adapter)
            }





        //Listviewの表をクリックしたときの動作
        list.setOnItemClickListener { adapterView , view , position , id ->
            //safe argsによる　friendsからFriendsDetailにデータ渡し
            //https://qiita.com/m-coder/items/3a8e66d49f2830b09bf4
            //real_nameには、ユーザーネームが配列で格納されているのでそれをpositionで設定してる
            //Toast.makeText(context , real_name[position] , Toast.LENGTH_SHORT).show()

            //real_name
            val Bundle = real_name[position]
            Toast.makeText(context, "$Bundle", Toast.LENGTH_SHORT).show()



            //友達登録するか否かのダイアログ表示
            AlertDialog.Builder(requireActivity())
                .setTitle(display_name[position])
                .setMessage("友達登録しますか？")




                .setPositiveButton("OK") { dialog , which ->

                    val admit_friends=hashMapOf(
                         "name" to real_name[position] ,
                    )


                    db.collection("users_profile").document("$user_name")
                        .collection("admit_friends").document(name[position]+user_name).set(admit_friends)
                }


                .setNegativeButton("No", { dialog, which ->
                    // TODO:Noが押された時の挙動
                })

                .show()


        }








    }
}
























