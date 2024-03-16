package com.example.core.extension

import android.app.Application
import android.content.Context


private const val AUTH_STATE = "auth_state"
private const val KEY_LOGIN_DATA = "login"
private const val EMPTY_DATA = ""
fun getCurrentUserLogin(context: Context): String {

    val sharedPreferences = context.getSharedPreferences(AUTH_STATE, Context.MODE_PRIVATE)
    return sharedPreferences.getString(KEY_LOGIN_DATA, EMPTY_DATA) ?: EMPTY_DATA
}

