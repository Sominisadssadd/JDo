package com.example.authentication.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.authentication.presentation.utils.consts.REGISTER_SCREEN
import com.example.authentication.presentation.utils.typers.FragmentType

class AuthenticationRegisterFragment : Fragment(), FragmentType {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {

        super.onDestroyView()
    }

    fun newInstance(): AuthenticationRegisterFragment {
        TODO()
    }

    override fun getFragmentType(): Int {
        return REGISTER_SCREEN
    }

}