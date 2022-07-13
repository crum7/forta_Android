package com.forta.housei_kokusai


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


        //特定のフラグメントのときにbottom_menuとtoolbarを消す。




        navController = navHostFragment.findNavController()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)






        //buttom menuの定義

        val buttomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.nav_host_fragment)


        //login2とfirsttimeでは、bottom_menuとtoolbarを消す
        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolbar.visibility = if(destination.id == R.id.login2 || destination.id == R.id.firsttime) View.GONE else View.VISIBLE
            buttomNavigationView.visibility = if(destination.id == R.id.login2 || destination.id == R.id.firsttime || destination.id == R.id.firsttime_2 || destination.id == R.id.firsttime_3 || destination.id == R.id.firsttime_4) View.GONE else View.VISIBLE
        }








        buttomNavigationView.setupWithNavController(navController)




        //アプリの起動回数把握        ここは、login.ktとも密接に関わってるから消したらだめ-----------------------------------------------------------------
        val launch_count = getSharedPreferences("ファイル名" , Context.MODE_PRIVATE)
        var countTime = launch_count.getInt("Count" , 0)
        countTime++

        launch_count.edit().putInt("Count",countTime).apply()

        //初回時にやることを書く
        if(countTime ==1){






        }





    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()


    }
}
