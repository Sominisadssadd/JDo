package com.example.core.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(
    private val viewModelClass: KClass<VM>,
    private val viewModelFactory: ViewModelProvider.Factory? = null
) : Fragment() {

    private var _binding: VB? = null
    protected val binding: VB
        get() = requireNotNull(_binding) { throw RuntimeException("binding == null") }

    protected val viewModel: VM by lazy {
        ViewModelProvider(this, viewModelFactory ?: ViewModelProvider.NewInstanceFactory()).get(viewModelClass.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = createBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    abstract fun setUpViews()
    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}