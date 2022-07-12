package com.forta.housei_kokusai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class zikannwariFriendsDetail : Fragment() {
    var navController: NavController? = null
    val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater ,
        container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View? {
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zikannwari_friends_detail,container ,false)
    }

    override fun onViewCreated(view: View ,savedInstanceState: Bundle?) {
        super.onViewCreated(view ,savedInstanceState)

        navController = Navigation.findNavController(view)



        //TextView
        val Getuyou1_txt  = requireActivity().findViewById<TextView>(R.id.Getuyou_1_friends)
        val Getuyou2_txt  = requireActivity().findViewById<TextView>(R.id.Getuyou_2_friends)
        val Getuyou3_txt  = requireActivity().findViewById<TextView>(R.id.Getuyou_3_friends)
        val Getuyou4_txt  = requireActivity().findViewById<TextView>(R.id.Getuyou_4_friends)
        val Getuyou5_txt  = requireActivity().findViewById<TextView>(R.id.Getuyou_5_friends)
        val Getuyou6_txt  = requireActivity().findViewById<TextView>(R.id.Getuyou_6_friends)

        val Kayou1_txt  = requireActivity().findViewById<TextView>(R.id.Kayou_1_friends)
        val Kayou2_txt  = requireActivity().findViewById<TextView>(R.id.Kayou_2_friends)
        val Kayou3_txt  = requireActivity().findViewById<TextView>(R.id.Kayou_3_friends)
        val Kayou4_txt  = requireActivity().findViewById<TextView>(R.id.Kayou_4_friends)
        val Kayou5_txt  = requireActivity().findViewById<TextView>(R.id.Kayou_5_friends)
        val Kayou6_txt  = requireActivity().findViewById<TextView>(R.id.Kayou_6_friends)

        val Suiyou1_txt  = requireActivity().findViewById<TextView>(R.id.Suiyou_1_friends)
        val Suiyou2_txt  = requireActivity().findViewById<TextView>(R.id.Suiyou_2_friends)
        val Suiyou3_txt  = requireActivity().findViewById<TextView>(R.id.Suiyou_3_friends)
        val Suiyou4_txt  = requireActivity().findViewById<TextView>(R.id.Suiyou_4_friends)
        val Suiyou5_txt  = requireActivity().findViewById<TextView>(R.id.Suiyou_5_friends)
        val Suiyou6_txt  = requireActivity().findViewById<TextView>(R.id.Suiyou_6_friends)

        val Mokuyou1_txt  = requireActivity().findViewById<TextView>(R.id.Mokuyou_1_friends)
        val Mokuyou2_txt  = requireActivity().findViewById<TextView>(R.id.Mokuyou_2_friends)
        val Mokuyou3_txt  = requireActivity().findViewById<TextView>(R.id.Mokuyou_3_friends)
        val Mokuyou4_txt  = requireActivity().findViewById<TextView>(R.id.Mokuyou_4_friends)
        val Mokuyou5_txt  = requireActivity().findViewById<TextView>(R.id.Mokuyou_5_friends)
        val Mokuyou6_txt  = requireActivity().findViewById<TextView>(R.id.Mokuyou_6_friends)

        val Kinyou1_txt  = requireActivity().findViewById<TextView>(R.id.Kinyou_1_friends)
        val Kinyou2_txt  = requireActivity().findViewById<TextView>(R.id.Kinyou_2_friends)
        val Kinyou3_txt  = requireActivity().findViewById<TextView>(R.id.Kinyou_3_friends)
        val Kinyou4_txt  = requireActivity().findViewById<TextView>(R.id.Kinyou_4_friends)
        val Kinyou5_txt  = requireActivity().findViewById<TextView>(R.id.Kinyou_5_friends)
        val Kinyou6_txt  = requireActivity().findViewById<TextView>(R.id.Kinyou_6_friends)





        val Name_KEY = arguments?.getString("NameKey").toString()

        val Getuyou1 =
            db.collection("users_data").document(Name_KEY).collection("Getuyou1").document("*")
        val Getuyou2 =
            db.collection("users_data").document(Name_KEY).collection("Getuyou2").document("*")
        val Getuyou3 =
            db.collection("users_data").document(Name_KEY).collection("Getuyou3").document("*")
        val Getuyou4 =
            db.collection("users_data").document(Name_KEY).collection("Getuyou4").document("*")
        val Getuyou5 =
            db.collection("users_data").document(Name_KEY).collection("Getuyou5").document("*")
        val Getuyou6 =
            db.collection("users_data").document(Name_KEY).collection("Getuyou6").document("*")


        val  Kayou1 =
            db.collection("users_data").document(Name_KEY).collection("Kayou1").document("*")
        val Kayou2 =
            db.collection("users_data").document(Name_KEY).collection("Kayou2").document("*")
        val Kayou3 =
            db.collection("users_data").document(Name_KEY).collection("Kayou3").document("*")
        val Kayou4 =
            db.collection("users_data").document(Name_KEY).collection("Kayou4").document("*")
        val Kayou5 =
            db.collection("users_data").document(Name_KEY).collection("Kayou5").document("*")
        val Kayou6 =
            db.collection("users_data").document(Name_KEY).collection("Kayou6").document("*")


        val  Suiyou1 =
            db.collection("users_data").document(Name_KEY).collection("Suiyou1").document("*")
        val Suiyou2 =
            db.collection("users_data").document(Name_KEY).collection("Suiyou2").document("*")
        val Suiyou3 =
            db.collection("users_data").document(Name_KEY).collection("Suiyou3").document("*")
        val Suiyou4 =
            db.collection("users_data").document(Name_KEY).collection("Suiyou4").document("*")
        val Suiyou5 =
            db.collection("users_data").document(Name_KEY).collection("Suiyou5").document("*")
        val Suiyou6 =
            db.collection("users_data").document(Name_KEY).collection("Suiyou6").document("*")


        val  Mokuyou1 =
            db.collection("users_data").document(Name_KEY).collection("Mokuyou1").document("*")
        val Mokuyou2 =
            db.collection("users_data").document(Name_KEY).collection("Mokuyou2").document("*")
        val Mokuyou3 =
            db.collection("users_data").document(Name_KEY).collection("Mokuyou3").document("*")
        val Mokuyou4 =
            db.collection("users_data").document(Name_KEY).collection("Mokuyou4").document("*")
        val Mokuyou5 =
            db.collection("users_data").document(Name_KEY).collection("Mokuyou5").document("*")
        val Mokuyou6 =
            db.collection("users_data").document(Name_KEY).collection("Mokuyou6").document("*")



        val  Kinyou1 =
            db.collection("users_data").document(Name_KEY).collection("Kinyou1").document("*")
        val Kinyou2 =
            db.collection("users_data").document(Name_KEY).collection("Kinyou2").document("*")
        val Kinyou3 =
            db.collection("users_data").document(Name_KEY).collection("Kinyou3").document("*")
        val Kinyou4 =
            db.collection("users_data").document(Name_KEY).collection("Kinyou4").document("*")
        val Kinyou5 =
            db.collection("users_data").document(Name_KEY).collection("Kinyou5").document("*")
        val Kinyou6 =
            db.collection("users_data").document(Name_KEY).collection("Kinyou6").document("*")


        val Getuyou1Items = arrayListOf("")
        val Getuyou2Items = arrayListOf("")
        val Getuyou3Items = arrayListOf("")
        val Getuyou4Items = arrayListOf("")
        val Getuyou5Items = arrayListOf("")
        val Getuyou6Items = arrayListOf("")
        val Getuyou7Items = arrayListOf("")

        val Kayou1Items = arrayListOf("")
        val Kayou2Items = arrayListOf("")
        val Kayou3Items = arrayListOf("")
        val Kayou4Items = arrayListOf("")
        val Kayou5Items = arrayListOf("")
        val Kayou6Items = arrayListOf("")
        val Kayou7Items = arrayListOf("")

        val Suiyou1Items = arrayListOf("")
        val Suiyou2Items = arrayListOf("")
        val Suiyou3Items = arrayListOf("")
        val Suiyou4Items = arrayListOf("")
        val Suiyou5Items = arrayListOf("")
        val Suiyou6Items = arrayListOf("")
        val Suiyou7Items = arrayListOf("")


        val Mokuyou1Items = arrayListOf("")
        val Mokuyou2Items = arrayListOf("")
        val Mokuyou3Items = arrayListOf("")
        val Mokuyou4Items = arrayListOf("")
        val Mokuyou5Items = arrayListOf("")
        val Mokuyou6Items = arrayListOf("")
        val Mokuyou7Items = arrayListOf("")

        val Kinyou1Items = arrayListOf("")
        val Kinyou2Items = arrayListOf("")
        val Kinyou3Items = arrayListOf("")
        val Kinyou4Items = arrayListOf("")
        val Kinyou5Items = arrayListOf("")
        val Kinyou6Items = arrayListOf("")
        val Kinyou7Items = arrayListOf("")




        //教科ごとの色分け
//現代文A・現代文B・古典A・古典B・現代の国語
//数学B・数学α・数学Ⅱ・数学Ⅱ基礎・数学Ⅱ発展・数学Ⅲ・数学研究Ⅰ・数学研究Ⅱ・数学研究Ⅲ
//英コミュⅠAd英文法Ⅰ英文法Ⅱ英文法Ⅲ英文読解Ⅰ英文読解Ⅱ英
//化学研究化学
//現代社会倫理史

        val japanese = arrayListOf(
            "現代文A 112" ,
            "現代文B 111" ,
            "現代文B 112" ,
            "現代文B 113" ,
            "古典A 114" ,
            "古典B 111" ,
            "現代の国語 227" ,
            "現代の国語 216" ,
            "現代の国語 111" ,
            "現代の国語 112" ,
            "現代の国語 227" ,
            "JapaneseA 224" ,
            "JapaneseA 226" ,
            "論理表現Ⅰ 215" ,
            "論理表現Ⅰ 216" ,
            "論理表現Ⅰ 222" ,
            "論理表現Ⅰ 228"
        )
        val math = arrayListOf(
            "数学B 223" ,
            "数学α 114" ,
            "数学α 227" ,
            "数学α 216" ,
            "数学α 222" ,
            "数学α 227" ,
            "数学α 221" ,
            "数学Ⅱ基礎 227" ,
            "数学Ⅱ基礎 228" ,
            "数学Ⅱ発展 223" ,
            "数学Ⅱ発展 227" ,
            "数学Ⅱ発展 233" ,
            "数学Ⅲ 228" ,
            "数学研究Ⅰ 214" ,
            "数学研究Ⅱ 223" ,
            "数学研究Ⅲ 215" ,
            "Mathematics 226" ,
        )
        val english = arrayListOf(
            "英コミュⅠAd 227" ,
            "英文法Ⅰ　222" ,
            "英文法Ⅰ 221" ,
            "英コミュⅠAd 228" ,
            "英文法Ⅰ 228" ,
            "英文法Ⅱ　214" ,
            "英文法Ⅱ 222" ,
            "英文法Ⅲ 216" ,
            "英文読解Ⅰ 223" ,
            "英文読解Ⅰ 221" ,
            "英文読解Ⅰ 234" ,
            "英文読解Ⅱ 216" ,
            "InteractiveEnglishⅠ 228" ,
            "InteractiveEnglishⅠ 235" ,
            "InteractiveEnglishⅠ 223" ,
            "InteractiveEnglishⅠ 222" ,
            "InteractiveEnglishⅡ 221" ,
            "InteractiveEnglishⅡ 216" ,
            "InteractiveEnglishⅡ 214" ,
            "Interactive EnglishⅡ 214" ,
            "Interactive EnglishⅠⅠ 214" ,
            "EnglishB 224" ,
            "EnglishB 226" ,
            "韓国語 221" ,
            "スペイン語 215" ,
            "イタリア語 214" ,
            "フランス語 214" ,
            "中国語 223" ,
            "ドイツ語 214"
        )
        val science = arrayListOf(
            "化学研究 321" ,
            "化学 321" ,
            "Chemistry 226" ,
            "Chemistry 224" ,
            "生物研究 322" ,
            "生物基礎 322" ,
            "生物基礎 331" ,
            "物理研究 332" ,
            "物理 332" ,
            "Biology 224" ,
            "発展物理 431" ,
        )
        val social = arrayListOf(
            "現代社会 441" ,
            "現代社会 431" ,
            "倫理 431" ,
            "日本史B 433" ,
            "日本史B 432" ,
            "日本史総合 433" ,
            "日本史総合 432" ,
            "世界史B 433" ,
            "世界史総合 441" ,
            "政治経済 432",
            "地理A 114" ,
            "地理A 431" ,
            "地理A 441" ,
        )
        val other = arrayListOf(
            "HR" ,
            "体育" ,
            "映像文化と自己表現Ⅰ 111" ,
            "江戸東京怪談文化の謎 112" ,
            "テクストの記号学 216" ,
            "起業家養成塾 441" ,
            "自分探しとふれあいの心理学 433" ,
            "世界の今のエシカル 214" ,
            "ヨコハマの歴史といま 432" ,
            "器楽 445" ,
            "ソルフェージュ 311" ,
            "ディズニーで探究する英語学習法 234" ,
            "きもの学 321" ,
            "マルチメディアとプレゼンテーション演習 231" ,
            "古典購読 114" ,
            "美術Ⅲ 323" ,
            "映像文化と自己表現Ⅱ 112" ,
            "書の世界 111" ,
            "文化の源泉 114" ,
            "旅する人の観光学 432" ,
            "ヒトの生物学 321" ,
            "私たちの生活とスポーツ 235" ,
            "演奏研究 445" ,
            "声楽 311" ,
            "私たちのまわりのデザイン工芸 323" ,
            "ディズニーで探究する英語学習法Ⅱ 234" ,
            "和の文化と調理学 431" ,
            "極限と人間 223" ,
            "News in English 222" ,
            "CriticalThinking 216" ,
            "現代の国語 227" ,
            "CriticalThinking 221" ,
            "CriticalThinking 228" ,
            "卒業論文" ,
            "卒論" ,
            "家庭基礎 222" ,
            "家庭基礎 431" ,
            "韓国語 221" ,
            "音楽Ⅱ 445" ,
            "音楽Ⅲ 445" ,
            "異文化理解Ⅰ 235" ,
            "異文化理解Ⅰ 234" ,

            )


        var subject=""


        Getuyou1.get()
            .addOnSuccessListener { document ->
                if (document != null) {

                    subject = document.data.toString().replace(Regex("[={}*]"), "")
                        .replace("Getuyou1", "")


                    Getuyou1_txt.setText(subject)
                    
                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Getuyou1_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Getuyou1_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Getuyou1_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Getuyou1_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Getuyou1_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Getuyou1_txt.setBackgroundResource(R.drawable.other)
                    }


                }






            }


        Getuyou2.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Getuyou2","")
                    Getuyou2_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Getuyou2_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Getuyou2_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Getuyou2_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Getuyou2_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Getuyou2_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Getuyou2_txt.setBackgroundResource(R.drawable.other)
                    }
                }
            }

        Getuyou3.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Getuyou3","")
                    Getuyou3_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Getuyou3_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Getuyou3_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Getuyou3_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Getuyou3_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Getuyou3_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Getuyou3_txt.setBackgroundResource(R.drawable.other)
                    }
                    
                }
            }

        Getuyou4.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Getuyou4","")
                    Getuyou4_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Getuyou4_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Getuyou4_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Getuyou4_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Getuyou4_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Getuyou4_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Getuyou4_txt.setBackgroundResource(R.drawable.other)
                    }
                    
                }
            }

        Getuyou5.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Getuyou5","")
                    Getuyou5_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Getuyou5_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Getuyou5_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Getuyou5_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Getuyou5_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Getuyou5_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Getuyou5_txt.setBackgroundResource(R.drawable.other)
                    }
                    
                }
            }
        Getuyou6.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Getuyou6","")
                    Getuyou6_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Getuyou6_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Getuyou6_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Getuyou6_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Getuyou6_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Getuyou6_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Getuyou6_txt.setBackgroundResource(R.drawable.other)
                    }
                    
                }
            }

        
        
        
        
        
        
        
        Kayou1.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kayou1","")
                    Kayou1_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kayou1_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kayou1_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kayou1_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                       Kayou1_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kayou1_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kayou1_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }


        Kayou2.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kayou2","")
                    Kayou2_txt.setText(subject)



                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kayou2_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kayou2_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kayou2_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kayou2_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kayou2_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kayou2_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }

        Kayou3.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kayou3","")
                    Kayou3_txt.setText(subject)



                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kayou3_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kayou3_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kayou3_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kayou3_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kayou3_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kayou3_txt.setBackgroundResource(R.drawable.other)
                    }

                }
            }

        Kayou4.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kayou4","")
                    Kayou4_txt.setText(subject)



                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kayou4_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kayou4_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kayou4_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kayou4_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kayou4_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kayou4_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }

        Kayou5.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kayou5","")
                    Kayou5_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kayou5_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kayou5_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kayou5_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kayou5_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kayou5_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kayou5_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }
        Kayou6.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kayou6","")
                    Kayou6_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kayou6_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kayou6_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kayou6_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kayou6_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kayou6_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kayou6_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }





        Suiyou1.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Suiyou1","")
                    Suiyou1_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                       Suiyou1_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Suiyou1_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Suiyou1_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Suiyou1_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Suiyou1_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Suiyou1_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }


        Suiyou2.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Suiyou2","")
                    Suiyou2_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Suiyou2_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Suiyou2_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Suiyou2_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Suiyou2_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Suiyou2_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Suiyou2_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }

        Suiyou3.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Suiyou3","")
                    Suiyou3_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Suiyou3_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Suiyou3_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Suiyou3_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Suiyou3_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Suiyou3_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Suiyou3_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }

        Suiyou4.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Suiyou4","")
                    Suiyou4_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Suiyou4_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Suiyou4_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Suiyou4_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Suiyou4_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Suiyou4_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Suiyou4_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }

        Suiyou5.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Suiyou5","")
                    Suiyou5_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Suiyou5_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Suiyou5_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Suiyou5_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Suiyou5_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Suiyou5_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Suiyou5_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }
        Suiyou6.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Suiyou6","")
                    Suiyou6_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Suiyou6_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Suiyou6_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Suiyou6_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Suiyou6_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Suiyou6_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Suiyou6_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }




        Mokuyou1.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Mokuyou1","")
                    Mokuyou1_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Mokuyou1_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Mokuyou1_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Mokuyou1_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Mokuyou1_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Mokuyou1_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Mokuyou1_txt.setBackgroundResource(R.drawable.other)
                    }
                }
            }


        Mokuyou2.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Mokuyou2","")
                    Mokuyou2_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Mokuyou2_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Mokuyou2_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Mokuyou2_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Mokuyou2_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Mokuyou2_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Mokuyou2_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }

        Mokuyou3.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Mokuyou3","")
                    Mokuyou3_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Mokuyou3_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Mokuyou3_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Mokuyou3_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Mokuyou3_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Mokuyou3_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Mokuyou3_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }

        Mokuyou4.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Mokuyou4","")
                    Mokuyou4_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Mokuyou4_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Mokuyou4_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Mokuyou4_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Mokuyou4_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Mokuyou4_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Mokuyou4_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }

        Mokuyou5.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Mokuyou5","")
                    Mokuyou5_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Mokuyou5_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Mokuyou5_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Mokuyou5_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Mokuyou5_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Mokuyou5_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Mokuyou5_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }
        Mokuyou6.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Mokuyou6","")
                    Mokuyou6_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Mokuyou6_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Mokuyou6_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Mokuyou6_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Mokuyou6_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Mokuyou6_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Mokuyou6_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }




        Kinyou1.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kinyou1","")
                    Kinyou1_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kinyou1_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kinyou1_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kinyou1_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kinyou1_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kinyou1_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kinyou1_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }


        Kinyou2.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kinyou2","")
                    Kinyou2_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kinyou2_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kinyou2_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kinyou2_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kinyou2_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kinyou2_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kinyou2_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }

        Kinyou3.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kinyou3","")
                    Kinyou3_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kinyou3_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kinyou3_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kinyou3_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kinyou3_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kinyou3_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kinyou3_txt.setBackgroundResource(R.drawable.other)
                    }


                }
            }

        Kinyou4.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kinyou4","")
                    Kinyou4_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kinyou4_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kinyou4_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kinyou4_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kinyou4_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kinyou4_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kinyou4_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }

        Kinyou5.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kinyou5","")
                    Kinyou5_txt.setText(subject)


                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kinyou5_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kinyou5_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kinyou5_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kinyou5_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kinyou5_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kinyou5_txt.setBackgroundResource(R.drawable.other)
                    }
                }
            }
        Kinyou6.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val subject = document.data.toString().replace(Regex("[={}*]") , "").replace("Kinyou6","")
                    Kinyou6_txt.setText(subject)

                    //背景色の設定
                    //positionは、選ばれたリストのindex
                    if (japanese.contains(subject)) {

                        Kinyou6_txt.setBackgroundResource(R.drawable.japanese)
                    } else if(math.contains(subject)){
                        Kinyou6_txt.setBackgroundResource(R.drawable.math)
                    }else if(english.contains(subject)){
                        Kinyou6_txt.setBackgroundResource(R.drawable.english)
                    }else if(science.contains(subject)){
                        Kinyou6_txt.setBackgroundResource(R.drawable.science)
                    } else if(social.contains(subject)){
                        Kinyou6_txt.setBackgroundResource(R.drawable.socieal)
                    }else if(other.contains(subject)){
                        Kinyou6_txt.setBackgroundResource(R.drawable.other)
                    }



                }
            }

    }
}