package com.example.core.extension

import android.app.Application
import android.content.Context


private const val AUTH_STATE = "auth_state"
private const val KEY_LOGIN_DATA = "login"
private const val KEY_ID_DATA = "id"
private const val KEY_ID_BOARD_DATA = "idBoard"
private const val EMPTY_DATA = ""
private const val EMPTY_DATA_INT = 0


fun getCurrentUserLogin(context: Context): String {

    val sharedPreferences = context.getSharedPreferences(AUTH_STATE, Context.MODE_PRIVATE)
    return sharedPreferences.getString(KEY_LOGIN_DATA, EMPTY_DATA) ?: EMPTY_DATA
}

fun getCurrentUserId(context: Context): Int {
    val sharedPreferences = context.getSharedPreferences(AUTH_STATE, Context.MODE_PRIVATE)
    return sharedPreferences.getInt(KEY_ID_DATA, EMPTY_DATA_INT)
}

fun getCurrentBoardId(context: Context): Int{
    val sharedPreferences = context.getSharedPreferences(AUTH_STATE, Context.MODE_PRIVATE)
    return sharedPreferences.getInt(KEY_ID_BOARD_DATA, EMPTY_DATA_INT)
}

