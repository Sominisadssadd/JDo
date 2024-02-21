package com.example.authentication.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.authentication.databinding.AuthenticationLoginLayoutBinding
import com.example.authentication.presentation.utils.consts.LOGIN_SCREEN
import com.example.authentication.presentation.utils.typers.FragmentType

class AuthenticationLoginFragment : Fragment(), FragmentType {

    private var _binding: AuthenticationLoginLayoutBinding? = null
    private val binding: AuthenticationLoginLayoutBinding
        get() = _binding ?: throw RuntimeException("AuthenticationLoginLayoutBinding == null")

    private val viewModel: AuthenticationLoginFragmentViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = AuthenticationLoginLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getFragmentType(): Int {
        return LOGIN_SCREEN
    }


}