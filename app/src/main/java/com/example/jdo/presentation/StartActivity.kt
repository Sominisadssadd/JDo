package com.example.jdo.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.authentication.presentation.authenticationcheckingfragment.AuthenticationCheckingFragment
import com.example.authentication.presentation.mainfrgment.AuthenticationBaseFragment
import com.example.authentication.presentation.utils.permission.CheckPermissionAuthentication
import com.example.authentication.presentation.utils.sharedPreferences.SharedPreferencesAuthentication
import com.example.jdo.R
import com.example.jdo.databinding.ActivityStartBinding
import com.google.android.material.snackbar.Snackbar

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding
    private lateinit var authSharedPreferences: SharedPreferencesAuthentication
    private lateinit var permissionsChecker: CheckPermissionAuthentication

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentContainerID = binding.fragmentContainerActivityStart.id
        authSharedPreferences = SharedPreferencesAuthentication(this)
        permissionsChecker = CheckPermissionAuthentication(this)
        permissionsChecker.checkUserPermissions()
        if (authSharedPreferences.isLoggedIn()) {
            toMainActivity()
        }
        val fragment = AuthenticationBaseFragment.newInstance().apply {
            activityListener = {
                authSharedPreferences.apply {
                    setLoginStatus(true)
                }

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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults.first() == PackageManager.PERMISSION_GRANTED) {
                val message = getString(R.string.permissions_granted)
                snackBarPermissionMessage(message)
            } else {
                val message = getString(R.string.permissions_ungranted)
                snackBarPermissionMessage(message)
            }
        }
    }

    private fun snackBarPermissionMessage(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 123
    }
}

