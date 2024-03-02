package com.example.jdo.presentation

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.authentication.presentation.mainfrgment.AuthenticationBaseFragment
import com.example.jdo.R
import com.example.jdo.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //сделать слушатель здесь, где при успешной авторизации, регистрации
        //отсюда идет переход на другую активность

        val fragment = AuthenticationBaseFragment.newInstance().apply {
            activityListener = {
                val intent = Intent(this@StartActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        val fragmentContainerID = binding.fragmentContainerActivityStart.id
        supportFragmentManager.beginTransaction().add(fragmentContainerID, fragment).commit()
    }
}