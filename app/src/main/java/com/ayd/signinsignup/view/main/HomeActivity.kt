package com.ayd.signinsignup.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.ayd.signinsignup.R
import com.ayd.signinsignup.databinding.ActivityHomeBinding
import com.ayd.signinsignup.util.Constant.RECEIVER_NO
import com.ayd.signinsignup.util.Constant.RECEIVER_YES
import com.ayd.signinsignup.view.fragments.HomeFragment
import com.ayd.signinsignup.view.fragments.SettingsFragment
import com.ayd.signinsignup.util.Constant.STATE_VALUE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragments(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> fragments(HomeFragment())
                R.id.settings -> fragments(SettingsFragment())
            }
            true
        }





        val reciever = intent.getBooleanExtra(STATE_VALUE,false)

        if(!reciever){
            Toast.makeText(this,RECEIVER_NO,Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this,RECEIVER_YES,Toast.LENGTH_SHORT).show()
        }



/*
        val darkReceiver = intent.getBooleanExtra("dark_mode",false)

        if(darkReceiver){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
*/


    }


    private fun fragments(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)  //not add, replace! I don't want overlapping fragments. So i used replace.
        fragmentTransaction.commit()

    }


}