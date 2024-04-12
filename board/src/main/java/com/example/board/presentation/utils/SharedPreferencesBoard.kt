package com.example.board.presentation.utils

import android.content.Context

class SharedPreferencesBoard(context: Context) {

    private val sharedPreferences = context.getSharedPreferences(AUTH_STATE, Context.MODE_PRIVATE)
    fun setIdData(id: Int) {
        sharedPreferences.edit().putInt(KEY_LOGIN_DATA, id).apply()
    }

    companion object {
        private const val AUTH_STATE = "auth_state"
        const val KEY_LOGIN_DATA = "idBoard"
    }

}