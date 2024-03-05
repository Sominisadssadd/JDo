package com.example.jdo.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.authentication.presentation.authenticationcheckingfragment.AuthenticationCheckingFragment
import com.example.authentication.presentation.mainfrgment.AuthenticationBaseFragment
import com.example.authentication.presentation.utils.sharedPreferences.SharedPreferencesAuthentication
import com.example.jdo.R
import com.example.jdo.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding
    private lateinit var authSharedPreferences: SharedPreferencesAuthentication

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentContainerID = binding.fragmentContainerActivityStart.id
        authSharedPreferences = SharedPreferencesAuthentication(this)
        if (authSharedPreferences.isLoggedIn()) {
            toMainActivity()
        }
        val fragment = AuthenticationBaseFragment.newInstance().apply {
            activityListener = {
                authSharedPreferences.setLoginStatus(true)
                toMainActivity()
            }
        }
        supportFragmentManager.beginTransaction().add(fragmentContainerID, fragment).commit()
    }

    private fun toMainActivity() {
        val intentToMainActivity = Intent(this@StartActivity, MainActivity::class.java)
        startActivity(intentToMainActivity)
        finish()
    }


}