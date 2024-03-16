package com.example.jdo.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jdo.R
import com.example.jdo.databinding.ActivityMainBinding
import com.example.jdo.presentation.main_fragment.MainFragment
import com.google.firebase.Firebase
import com.google.firebase.storage.FirebaseStorage

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val baseFragment = MainFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(binding.frameLayoutMain.id, baseFragment)
            .commit()

    }


}