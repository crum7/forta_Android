package com.example.housei_kokusai

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.IntentSender
import android.net.Uri
import android.os.Bundle
import com.google.firebase.firestore.ktx.firestore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.analytics.ktx.analytics



import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

//全ての処理をfragmentに任せる
//左上の”戻る”ボタンもここで管理している。 ↓
//https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-4?authuser=2&hl=ja#codelab-https://developer.android.com/codelabs/basic-android-kotlin-training-navigation-backstack

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController
    private lateinit var firebaseAnalytics: FirebaseAnalytics


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //googleアナリティクスの宣言
        firebaseAnalytics = Firebase.analytics

        //cloud firestoreの追加
        val db = Firebase.firestore


        //navigationコンポーネントの宣言
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)


        //buttom menuの定義

        val buttomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.nav_host_fragment)
        buttomNavigationView.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()


    }
}
