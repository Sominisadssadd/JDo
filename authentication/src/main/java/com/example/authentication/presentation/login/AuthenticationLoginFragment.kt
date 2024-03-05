package com.example.authentication.presentation.login

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.authentication.R
import com.example.authentication.databinding.AuthenticationLoginLayoutBinding
import com.example.authentication.domain.api.model.User
import com.example.authentication.presentation.login.actions.AuthenticationLoginFragmentActionLogin
import com.example.authentication.presentation.utils.sharedPreferences.SharedPreferencesAuthentication
import com.example.core.base.dialog.snackBarErrorMessage
import com.example.core.base.fragment.BaseFragment
import com.example.response.ResultResponse
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AuthenticationLoginFragment :
    BaseFragment<AuthenticationLoginLayoutBinding, AuthenticationLoginFragmentViewModel>(
        AuthenticationLoginFragmentViewModel::class
    ) {

    //replace standart initial of actions with dagger
    val loginAction by lazy {
        AuthenticationLoginFragmentActionLogin(this, viewModel)
    }

    lateinit var loginClickListener: () -> Unit
    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AuthenticationLoginLayoutBinding {
        return AuthenticationLoginLayoutBinding.inflate(inflater, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observableEvents()


    }

    override fun setUpViews() {
        binding.apply {
            buttonLogin.setOnClickListener {
                val login = binding.editTextLogin.text.toString()
                viewModel.setLoadingStatus(true)
                loginAction.loginUserWithLogin(login)
            }
        }
    }
    private fun clearText(){
        binding.apply {
            editTextLogin.text = null
            editTextPassword.text = null
        }
    }
    private fun observableEvents() {
        val buttonText = binding.buttonLogin.text
        val buttonColor = binding.buttonLogin.background
        viewModel.apply {
            loading.observe(viewLifecycleOwner) {
                if (it) {
                    binding.apply {
                        loadingBar.visibility = View.VISIBLE
                        buttonLogin.text = null
                    }
                } else {
                    binding.apply {
                        loadingBar.visibility = View.GONE
                        buttonLogin.text = buttonText
                        buttonLogin.background = buttonColor
                    }
                }
            }
            error.observe(viewLifecycleOwner) {
                snackBarErrorMessage(it)
                setLoadingStatus(false)
                clearText()
            }
            data.observe(viewLifecycleOwner) {
                val login = binding.editTextLogin.text.toString()
                val password = binding.editTextPassword.text.toString()
                val itData = it as ResultResponse<User>
                loginAction.checkUserIsExist(login, password, itData.data)
                setLoadingStatus(false)
            }
            success.observe(viewLifecycleOwner) {
                loginClickListener.invoke()
                setLoadingStatus(false)
            }
        }
    }


    fun newInstance() = AuthenticationLoginFragment()
}