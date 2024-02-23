package com.example.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> (
    private val viewModelClass: KClass<VM>,
    private val viewModelFactory: ViewModelProvider.Factory? = null
) :
    Fragment() {

    private var _binding: VB? = null
    protected val binding: VB
        get() = requireNotNull(_binding) { throw RuntimeException("binding == null") }

    protected val viewModel: VM by ViewModelLazy(
        viewModelClass,
        { viewModelStore },
        {
            requireNotNull(viewModelFactory) {
                defaultViewModelProviderFactory
            }
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = createBinding(inflater, container)
        return binding.root
    }

    abstract fun setUpViews()
    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}