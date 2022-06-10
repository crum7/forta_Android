package com.example.housei_kokusai


import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import com.example.housei_kokusai.R.id
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.housei_kokusai.home as home


//Fragmentを継承したclassを作る　これがなきゃ始まらない
class home:Fragment() ,View.OnClickListener{






    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//まずは、こいつでfragment_homeを表示する
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    //ボタンが押されたときの処理の大枠を作る
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.settings_move).setOnClickListener(this)
        view.findViewById<Button>(R.id.touroku_button).setOnClickListener(this)






    }

    //なんのボタンが押されたら、どの処理をするか。
    override fun onClick(v: View?) {
        when(v!!.id){

            R.id.settings_move-> navController!!.navigate(R.id.action_home_to_settings_name)
            R.id.touroku_button -> navController!!.navigate(R.id.action_home_to_settings_friends)



        }

    }

}



/*
var view = inflater.inflate(R.layout.fragment_home, container, false)
        val button = view.findViewById<Button>(R.id.touroku_button)
/*
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
       val action =
*/

        button.setOnClickListener { view ->
            //view.findNavController().navigate(R.id.manday)
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
        }
       return view

    }
 */

