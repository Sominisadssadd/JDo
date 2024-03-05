package com.example.authentication.presentation.register.actions

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.authentication.R
import com.example.authentication.domain.api.model.User
import com.example.authentication.presentation.register.AuthenticationRegisterFragmentViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AuthenticationRegisterFragmentAction(
    val fragment: Fragment,
    val viewModel: AuthenticationRegisterFragmentViewModel
) {
    fun registerLogin(user: User) {
        viewModel.registerUser(user)
            .onEach {
                viewModel.setData(it)
            }

            .catch {
                val errorMessage = fragment.getString(R.string.error_bad_internet_connection)
                viewModel.setError(errorMessage)
            }
            .launchIn(fragment.lifecycleScope)
    }
     fun checkEmptyFields(user: User): Boolean {
        return with(user) {
            login.isBlank() || password.isBlank() || phone.isBlank()
        }
    }


}