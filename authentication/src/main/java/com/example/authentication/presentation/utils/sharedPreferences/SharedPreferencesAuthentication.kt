package com.example.authentication.presentation.utils.sharedPreferences

import android.content.Context

class SharedPreferencesAuthentication(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(AUTH_STATE, Context.MODE_PRIVATE)
    fun setLoginStatus(isLogged: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_IS_LOGIN, isLogged).apply()
    }
    fun setLoginData(login: String){
        sharedPreferences.edit().putString(KEY_LOGIN_DATA,login).apply()
    }
    fun isLoggedIn() = sharedPreferences.getBoolean(KEY_IS_LOGIN, false)
    companion object {
        private const val AUTH_STATE = "auth_state"
        const val KEY_IS_LOGIN = "isLogin"
        const val KEY_LOGIN_DATA = "login"
    }

}