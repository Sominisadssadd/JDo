package com.example.authentication.presentation.login.actions

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.authentication.R
import com.example.authentication.domain.api.model.User
import com.example.authentication.presentation.login.AuthenticationLoginFragmentViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.mindrot.jbcrypt.BCrypt

class AuthenticationLoginFragmentActionLogin(
    val fragment: Fragment,
    val viewModel: AuthenticationLoginFragmentViewModel
) {
    fun loginUserWithLogin(userLogin: String) {
        viewModel.getUserByLogin(userLogin)
            .onEach {
                viewModel.pudData(it)
            }
            .catch {
                val errorMessage = fragment.getString(R.string.error_bad_internet_connection)
                viewModel.sendError(errorMessage)
            }
            .launchIn(fragment.lifecycleScope)
    }

    fun checkUserIsExist(login: String, password: String, userData: User?) {
        if (checkEmptyFields(login, password)) {
            val errorMessage = fragment.getString(R.string.error_empty_fields)
            viewModel.sendError(errorMessage)
            return
        }
        if (userData == null) {
            val errorMessage = fragment.getString(R.string.error_user_not_found)
            viewModel.sendError(errorMessage)
            return
        }
        if (login == userData.login && BCrypt.checkpw(password, userData.password)) {
            viewModel.successTrue(userId = userData.userId.toInt())
        } else {
            val errorMessage = fragment.getString(R.string.error_wrong_password)
            viewModel.sendError(errorMessage)
        }
    }

    private fun checkEmptyFields(login: String, password: String): Boolean {
        return login.isEmpty() && password.isEmpty()
    }
}