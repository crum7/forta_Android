package com.example.housei_kokusai


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

//全ての処理をfragmentに任せる
//左上の”戻る”ボタンもここで管理している。 ↓
//https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-4?authuser=2&hl=ja#codelab-https://developer.android.com/codelabs/basic-android-kotlin-training-navigation-backstack

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //アプリバーの色とか変える。


        //googleアナリティクスの宣言
        firebaseAnalytics = Firebase.analytics

        //cloud firestoreの追加
        val db = Firebase.firestore




        //navigationコンポーネントの宣言
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)






        //buttom menuの定義

        val buttomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.nav_host_fragment)
        buttomNavigationView.setupWithNavController(navController)




        //アプリの起動回数把握
        val launch_count = getSharedPreferences("ファイル名" , Context.MODE_PRIVATE)
        var countTime = launch_count.getInt("Count" , 0)
        countTime++
        launch_count.edit().putInt("Count",countTime).apply()

        //初回時にやることを書く
        if(countTime ==1){

            //bottom_menuとtoolbarを消す。
            buttomNavigationView.visibility = View.GONE
            toolbar.visibility = View.GONE



        }


    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()


    }
}
