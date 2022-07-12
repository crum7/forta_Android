package com.forta.housei_kokusai


import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
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
        val searchBar = view.findViewById<AutoCompleteTextView>(R.id.search_bar)


        var display_name = arrayListOf("")
        var real_name = arrayListOf("")
        var name = arrayListOf("")
        var my_virtual_name = ""
        var my_block_name = ""
        var kore = ""




        //swipe処理
        val kennsaku_SwipeRefreshLayout=view.findViewById<SwipeRefreshLayout>(R.id.kennsaku_SwipeRefreshLayout)
        // リストを下にスワイプされたら更新処理を実行
        kennsaku_SwipeRefreshLayout.setOnRefreshListener {



            var display_name_swipe = arrayListOf("")
            var real_name_swipe = arrayListOf("")
            var name_swipe = arrayListOf("")
            var my_virtual_name_swipe = ""
            var my_block_name_swipe = ""
            var kore_swipe = ""


            //ListViewの初期化
            val adapter_swipe = ArrayAdapter<String>(
                requireContext() ,
                android.R.layout.simple_list_item_1 ,
                display_name_swipe//本番環境ではhyouzi_array
            )


            searchBar.setAdapter(adapter_swipe)
            list.setAdapter(adapter_swipe)



            //自分のユーザーネーム
            db.collection("users_profile").document(user_name.toString())
                .get()
                .addOnSuccessListener { result_name ->
                    my_virtual_name_swipe = result_name.data.toString().replace(Regex("[={}*]") , "").replace("display_name","")

                }

            //自分がブロックした人を検索リストから消すために、ブロックした人の名前をblock_listから取得する。
            db.collection("users_profile").document(user_name.toString()).collection("block_list")
                .get()
                .addOnSuccessListener { result ->

                    for (document in result) {

                        db.collection("users_profile").document(document.id)
                            .get()
                            .addOnSuccessListener { result ->
                                my_block_name_swipe = result.data.toString().replace(Regex("[={}*]") , "").replace("display_name","")

                            }
                    }
                }








            db.collection("users_profile")
                .get()
                .addOnSuccessListener { result ->

                    for (document in result) {
                        Log.d(TAG , "${document.id} => ${document.data}")

                        name_swipe.add(document.data.toString())
                        kore_swipe = document.data.toString()


                        val tokusyu = kore_swipe.replace(Regex("[={}*]") , "").replace("display_name","")


                        //データ読み取り


                        //配列にする
                        display_name_swipe.add(tokusyu)
                        real_name_swipe.add(document.id)

                        //自分の名前とブロックした人の名前を削除
                        // ここで多分real_name[postion]との数字の関連性が取れなくなっててエラーで落ちる。なんとかしろ
                        display_name_swipe.remove(my_virtual_name)
                        display_name_swipe.remove(my_block_name)



                        //real_nameは自分のメールアドレスの先頭の文字が含まれているのでそれを消す。
                        real_name_swipe.remove(user_name.toString())


                    }
                    //ListViewで表示
                    val adapter_swipe = ArrayAdapter<String>(
                        requireContext() ,
                        android.R.layout.simple_list_item_1 ,
                        display_name_swipe//本番環境ではhyouzi_array
                    )


                    searchBar.setAdapter(adapter_swipe)
                    list.setAdapter(adapter_swipe)

                }





            //Listviewの表をクリックしたときの動作
            list.setOnItemClickListener { adapterView , view , position , id ->
                //safe argsによる　friendsからFriendsDetailにデータ渡し
                //https://qiita.com/m-coder/items/3a8e66d49f2830b09bf4
                //real_nameには、ユーザーネームが配列で格納されているのでそれをpositionで設定してる
                //Toast.makeText(context , real_name[position] , Toast.LENGTH_SHORT).show()

                //real_name
                val Bundle = real_name_swipe[position]





                //友達登録するか否かのダイアログ表示
                AlertDialog.Builder(requireActivity())
                    .setTitle(display_name_swipe[position])
                    .setMessage("友達登録しますか？")



                    //OKボタン
                    .setPositiveButton("OK") { dialog , which ->

                        val admit_friends=hashMapOf(
                            "name" to display_name_swipe[position] ,
                        )

                        val watch_by = hashMapOf(
                            "name" to my_virtual_name_swipe,
                        )


                        //admit_friendsに友達の名前を追記する
                        db.collection("users_profile").document("$user_name")
                            .collection("admit_friends").document(real_name_swipe[position+1]).set(admit_friends)


                        //users_profileの友達のwatch_byに追記する
                        db.collection("users_profile").document(real_name_swipe[position+1])
                            .collection("watch_by").document(user_name.toString()).set(watch_by)

                    }

                    //NOボタン
                    .setNegativeButton("No", { dialog, which ->
                        // TODO:Noが押された時の挙動
                    })

                    .show()


            }
            //クルクル止める
            kennsaku_SwipeRefreshLayout.setRefreshing(false)


        }


















        //検索したときの挙動-----------------------------------------------------
        searchBar.setOnFocusChangeListener{ v, hasFocus ->

        if (hasFocus){
            list.isTextFilterEnabled = true
            list.setFilterText(" ")
        }
        }


        searchBar.setOnItemClickListener { aaaaa, view, i, l ->
            val searchedName = aaaaa.getItemAtPosition(i) as String

            list.isTextFilterEnabled = true
            list.setFilterText(" ")




            //自分のユーザーネーム
            db.collection("users_profile").document(user_name.toString())
                .get()
                .addOnSuccessListener { result_name ->
                    val my_virtual_name = result_name.data.toString().replace(Regex("[={}*]") , "").replace("display_name","")

                }


            //友達登録するか否かのダイアログ表示
            AlertDialog.Builder(requireActivity())
                .setTitle(searchedName)
                .setMessage("友達登録しますか？")





                //OKボタン
                .setPositiveButton("OK") { dialog , which ->

                    val admit_friends=hashMapOf(
                        "name" to searchedName,
                    )

                    val watch_by = hashMapOf(
                        "name" to my_virtual_name,
                    )



                    //相手のrealNameがわかってない
                    db.collection("users_profile")
                        .get()
                        .addOnSuccessListener{ real_name_searched ->
                            for (document in real_name_searched) {


                                val data = document.data.toString().replace(Regex("[={}*]"),"").replace("display_name","")
                                if( data == searchedName )
                                {
                                    val real_name_searched_ans = document.id
                                    //Toast.makeText(requireContext() , real_name_searched_ans , Toast.LENGTH_SHORT).show()

                                    //admit_friendsに友達の名前を追記する
                                    db.collection("users_profile").document("$user_name")
                                        .collection("admit_friends").document(real_name_searched_ans).set(admit_friends)


                                    //users_profileの友達のwatch_byに追記する
                                    db.collection("users_profile").document(real_name_searched_ans)
                                        .collection("watch_by").document(user_name.toString()).set(watch_by)
                                }





                            }


                        }

                }

                //NOボタン
                .setNegativeButton("No", { dialog, which ->
                    // TODO:Noが押された時の挙動
                })

                .show()

            //Toast.makeText(requireContext(), "$searchedName が現れた！", Toast.LENGTH_SHORT).show()
        }
































        //自分のユーザーネーム
        db.collection("users_profile").document(user_name.toString())
            .get()
            .addOnSuccessListener { result_name ->
                my_virtual_name = result_name.data.toString().replace(Regex("[={}*]") , "").replace("display_name","")

            }

        //自分がブロックした人を検索リストから消すために、ブロックした人の名前をblock_listから取得する。
        db.collection("users_profile").document(user_name.toString()).collection("block_list")
            .get()
            .addOnSuccessListener { result ->

                for (document in result) {

                    db.collection("users_profile").document(document.id)
                        .get()
                        .addOnSuccessListener { result ->
                            my_block_name = result.data.toString().replace(Regex("[={}*]") , "").replace("display_name","")
                            //Toast.makeText(requireContext() , my_block_name , Toast.LENGTH_SHORT).show()
                        }
                }
            }








        db.collection("users_profile")
            .get()
            .addOnSuccessListener { result ->

                for (document in result) {
                    Log.d(TAG , "${document.id} => ${document.data}")

                    name.add(document.data.toString())
                    kore = document.data.toString()


                    val tokusyu = kore.replace(Regex("[={}*]") , "").replace("display_name","")


                    //データ読み取り


                    //配列にする
                    display_name.add(tokusyu)
                    real_name.add(document.id)

                    //自分の名前とブロックした人の名前を削除
                    // ここで多分real_name[postion]との数字の関連性が取れなくなっててエラーで落ちる。なんとかしろ
                    display_name.remove(my_virtual_name)
                    display_name.remove(my_block_name)



                    //real_nameは自分のメールアドレスの先頭の文字が含まれているのでそれを消す。
                    real_name.remove(user_name.toString())


                }
                //ListViewで表示
                val adapter = ArrayAdapter<String>(
                    requireContext() ,
                    android.R.layout.simple_list_item_1 ,
                    display_name//本番環境ではhyouzi_array
                )


                searchBar.setAdapter(adapter)
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


            //Toast.makeText(requireContext() , real_name[position+1] , Toast.LENGTH_SHORT).show()



            //友達登録するか否かのダイアログ表示
            AlertDialog.Builder(requireActivity())
                .setTitle(display_name[position])
                .setMessage("友達登録しますか？")



                    //OKボタン
                .setPositiveButton("OK") { dialog , which ->

                    val admit_friends=hashMapOf(
                         "name" to display_name[position] ,
                    )

                    val watch_by = hashMapOf(
                        "name" to my_virtual_name,
                    )


                    //admit_friendsに友達の名前を追記する
                    db.collection("users_profile").document("$user_name")
                        .collection("admit_friends").document(real_name[position+1]).set(admit_friends)


                    //users_profileの友達のwatch_byに追記する
                    db.collection("users_profile").document(real_name[position+1])
                        .collection("watch_by").document(user_name.toString()).set(watch_by)

                }

                    //NOボタン
                .setNegativeButton("No", { dialog, which ->
                    // TODO:Noが押された時の挙動
                })

                .show()


        }
    }
}
























