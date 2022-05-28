package com.example.housei_kokusai

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import androidx.annotation.WorkerThread
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.Timestamp
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.MetadataChanges
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ServerTimestamp
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.ArrayList
import java.util.Date
import java.util.HashMap
import java.util.concurrent.Callable
import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


class settings : Fragment() {


    private lateinit var database: DatabaseReference
    val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater ,container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings ,container ,false)
    }


    override fun onViewCreated(view: View ,savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)


        lateinit var auth: FirebaseAuth


        //val ref = database.getReference()
        auth=Firebase.auth

        //自分の名前
        val user_name=Firebase.auth.currentUser?.displayName.toString()
        //Toast.makeText(requireActivity() , user_name , Toast.LENGTH_SHORT).show()

        val changeName=requireActivity().findViewById<EditText>(R.id.changeName)
        val nowname=requireActivity().findViewById<TextView>(R.id.nowname)
        val dare =requireActivity().findViewById<ListView>(R.id.list_dare)
        val block=requireActivity().findViewById<ListView>(R.id.list_block)


        //誰が自分の時間割を見ているか用
        var display_name = arrayListOf("")
        var real_name2=arrayListOf("")
        var name_array = arrayListOf("")

        //自分がブロックした人
        var display_name_blo = arrayListOf("")
        var real_name2_blo=arrayListOf("")
        var name_array_blo = arrayListOf("")

        var documentID = ""
        var name_who = ""





        //誰が自分の時間割りを見ているか
        db.collection("users_profile")
            .get()
            .addOnSuccessListener { result ->


                for (document in result) {
                    Log.d(TAG , "${document.id} => ${document.data}")

                    val name = document.data.toString()
                    name_array.add(document.data.toString())
                    //Toast.makeText(context , document.id.toString() , Toast.LENGTH_SHORT).show()

                    documentID=document.id

                    val tokusyu = name.replace(Regex("[={}*]") , "").replace("display_name","")


                    db.collection("users_profile").document(document.id.toString()).collection("admit_friends").whereEqualTo("name",user_name)
                        .get()
                        .addOnSuccessListener { result ->




                            for (document in result) {
                                Log.d(TAG , "${document.id} => ${document.data}")
                                display_name.add(document.id.toString())
                                real_name2.add(document.id)

                                name_who = document.id



                                //Toast.makeText(context , document.id.toString() , Toast.LENGTH_SHORT).show()


                            }
                            val adapter=ArrayAdapter<String>(
                                requireContext() ,
                                android.R.layout.simple_list_item_1 ,
                                display_name//本番環境ではhyouzi_array
                            )
                            dare.setAdapter(adapter)



                        }






                }



            }



        //自分の時間割を見ている人の中からブロックする人を決める。
        //Listviewの表をクリックしたときの動作
        dare.setOnItemClickListener { adapterView , view , position , id ->
            //safe argsによる　friendsからFriendsDetailにデータ渡し
            //https://qiita.com/m-coder/items/3a8e66d49f2830b09bf4
            //real_nameには、ユーザーネームが配列で格納されているのでそれをpositionで設定してる
            //Toast.makeText(context , real_name[position] , Toast.LENGTH_SHORT).show()

            //real_name
            val Bundle = real_name2[position]
            //Toast.makeText(context, "$Bundle", Toast.LENGTH_SHORT).show()



            //ブロックするかどうかのダイアログ表示
            AlertDialog.Builder(requireActivity())
                .setTitle(display_name[position])
                .setMessage("ブロックしますか？")




                .setPositiveButton("OK") { dialog , which ->

                    val blocklist=hashMapOf(
                        "name" to real_name2[position] ,
                    )

                    //block_listに名前を追記する
                    db.collection("users_profile").document("$user_name")
                        .collection("block_list").document(real_name2[position]).set(blocklist)

                    //blockされてる方のadmit_firendsから自分の名前を消す。
                    db.collection("users_profile").document(documentID).collection("admit_friends").document(name_who)
                        .delete()
                        .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
                        .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }

                    /*
                    //blockされてる方に誰にブロックされているかを書く。
                    db.collection("users_profile").document(documentID).collection("blocked_by").document(name_who)
                        .set(user_name)*/





                    //ここのコレクションからブロックした人のドキュメントを削除

                    db.collection("users_profile").document(user_name).collection("admit_friends").document(real_name2[position])
                        .delete()
                        .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully deleted!") }
                        .addOnFailureListener { e -> Log.w(TAG, "Error deleting document", e) }
                }





                .setNegativeButton("No", { dialog, which ->
                    // TODO:Noが押された時の挙動
                })

                .show()


        }














        //ブロックしている人を見る
        db.collection("users_profile")
            .get()
            .addOnSuccessListener { result ->


                for (document in result) {
                    Log.d(TAG , "${document.id} => ${document.data}")

                    val name_blo = document.data.toString()
                    name_array_blo.add(document.data.toString())
                    //Toast.makeText(context , document.id.toString() , Toast.LENGTH_SHORT).show()

                    val tokusyu_blo = name_blo.replace(Regex("[={}*]") , "").replace("display_name","")


                    db.collection("users_profile").document(document.id.toString()).collection("block_list")
                        .get()
                        .addOnSuccessListener { result ->




                            for (document in result) {
                                Log.d(TAG , "${document.id} => ${document.data}")
                                display_name_blo.add(document.id.toString())
                                real_name2_blo.add(document.id)
                                //Toast.makeText(context , document.id.toString() , Toast.LENGTH_SHORT).show()


                            }
                            val adapter=ArrayAdapter<String>(
                                requireContext() ,
                                android.R.layout.simple_list_item_1 ,
                                display_name_blo//本番環境ではhyouzi_array
                            )
                            block.setAdapter(adapter)



                        }






                }



            }



        //自分の時間割を見ている人の中からブロックする人を決める。
        //Listviewの表をクリックしたときの動作
        block.setOnItemClickListener { adapterView , view , position , id ->
            //safe argsによる　friendsからFriendsDetailにデータ渡し
            //https://qiita.com/m-coder/items/3a8e66d49f2830b09bf4
            //real_nameには、ユーザーネームが配列で格納されているのでそれをpositionで設定してる
            //Toast.makeText(context , real_name[position] , Toast.LENGTH_SHORT).show()

            //real_name
            val Bundle_blo = real_name2_blo[position]
            //Toast.makeText(context, "$Bundle_blo", Toast.LENGTH_SHORT).show()



            //友達登録するか否かのダイアログ表示
            AlertDialog.Builder(requireActivity())
                .setTitle(display_name_blo[position])
                .setMessage("ブロック解除しますか？")




                .setPositiveButton("OK") { dialog , which ->

                    val blocklist=hashMapOf(
                        "name" to real_name2_blo[position] ,
                    )


                    db.collection("users_profile").document("$user_name")
                        .collection("block_list").document(name_array[position]+user_name+"}").set(blocklist)
                }


                .setNegativeButton("No", { dialog, which ->
                    // TODO:Noが押された時の挙動
                })

                .show()


        }
































        //データ読み取り
        val docRef=db.collection("users_profile").document("$user_name")
        docRef.addSnapshotListener { snapshot , e ->
            if (e != null) {
                Log.w(TAG , "Listen failed." , e)

                //Toast.makeText(context , "${snapshot?.data}" , Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            if (snapshot != null && snapshot.exists()) {

                nowname.setText(
                    snapshot.data.toString().replace(Regex("[={}*]") , "")
                        .replace("display_name" , "")
                )
            } else {
                Log.d(TAG , "Current data: null")
                //Toast.makeText(context , "${snapshot?.data}" , Toast.LENGTH_SHORT).show()


                //名前が設定されてなかったら、メールアドレスの名前を入れる。

                val original_name=hashMapOf(
                    "display_name" to user_name ,

                    )


                db.collection("users_profile").document("$user_name")
                    .set(original_name as Map<String , Any>)


            }
        }


        val button=view.findViewById<Button>(R.id.save_button_name)


        button.setOnClickListener {


            val willName=changeName.text.toString()



            val custom_name=hashMapOf(
                "display_name" to willName ,

                )


            //名前の更新

            db.collection("users_profile").document("$user_name")
                .update(custom_name as Map<String , Any>)


        }



    }


    }





