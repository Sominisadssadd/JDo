package com.example.authentication.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.authentication.R
import com.example.authentication.databinding.AuthenticationRegisterLayoutBinding
import com.example.authentication.domain.api.model.User
import com.example.authentication.presentation.register.actions.AuthenticationRegisterFragmentAction
import com.example.authentication.presentation.utils.sharedPreferences.SharedPreferencesAuthentication
import com.example.core.base.dialog.snackBarErrorMessage
import com.example.core.base.fragment.BaseFragment
import com.example.core.extension.getCurrentUserLogin
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach

class AuthenticationRegisterFragment :
    BaseFragment<AuthenticationRegisterLayoutBinding, AuthenticationRegisterFragmentViewModel>(
        AuthenticationRegisterFragmentViewModel::class
    ) {
    lateinit var actionRegister: AuthenticationRegisterFragmentAction
    lateinit var registerClickListener: () -> Unit
    private lateinit var authSharedPreferences: SharedPreferencesAuthentication
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionRegister = AuthenticationRegisterFragmentAction(this, viewModel)
        authSharedPreferences = SharedPreferencesAuthentication(requireContext())
    }

    override fun setUpViews() {
        binding.apply {
            buttonRegister.setOnClickListener {
                val login = editTextLogin.text.toString()
                val phone = editTextPhone.text.toString()
                val password = editTextPassword.text.toString()
                val user = User(login = login, password = password, phone = phone)
                val fieldsIsEmpty = actionRegister.checkEmptyFields(user)
                if (fieldsIsEmpty) {
                    val errorMessage = getString(R.string.error_empty_fields)
                    viewModel.setError(errorMessage)
                    return@setOnClickListener
                }
                actionRegister.registerLogin(user)
            }
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AuthenticationRegisterLayoutBinding {
        return AuthenticationRegisterLayoutBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observableEvents()
    }

    private fun observableEvents() {
        viewModel.apply {
            success.observe(viewLifecycleOwner) {
                val login = binding.editTextLogin.text.toString()
                with(authSharedPreferences) {
                    setLoginData(login)
                    setIdData(it)
                }
                registerClickListener.invoke()
            }
            result.observe(viewLifecycleOwner) {
                if (it.success.equals(true)) {
                    setSuccess(it.data?.userId?.toInt()!!)
                } else {
                    val errorMessage = getString(R.string.error_user_already_exist)
                    viewModel.setError(errorMessage)
                }
            }
            error.observe(viewLifecycleOwner) {
                snackBarErrorMessage(it)
            }
            loading.observe(viewLifecycleOwner) {

            }
        }
    }

    fun newInstance() = AuthenticationRegisterFragment()

}