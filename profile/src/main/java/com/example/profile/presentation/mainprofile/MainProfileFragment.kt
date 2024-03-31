package com.example.profile.presentation.mainprofile

import android.R.attr.entries
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.core.base.dialog.snackBarErrorMessage
import com.example.core.base.dialog.snackBarMessage
import com.example.core.base.fragment.BaseFragment
import com.example.profile.R
import com.example.profile.databinding.MainProfileFragmentBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry


class MainProfileFragment(context: Context) : BaseFragment<MainProfileFragmentBinding, MainProfileFragmentViewModel>(
    MainProfileFragmentViewModel::class,
    MainProfileViewModelFactory(context)
) {
    override fun setUpViews() {
        binding.apply {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observableEvents()
        viewModel.getUserInfo()
    }
    private fun observableEvents() {
        viewModel.apply {
            error.observe(viewLifecycleOwner) {
                snackBarErrorMessage(it)
            }
            dataUser.observe(viewLifecycleOwner) {
                binding.apply {
                    with(it) {
                        Glide.with(requireContext())
                            .load(imageId.getImageUrl())
                            .into(ivProfileImage)
                        tvProfileEmail.text = email
                        tvProfileLogin.text = "@$login"
                        tvProfileName.text = name
                        tvProfileSerName.text = serName
                        tvProfilePhone.text = phone
                    }

                }
            }
            success.observe(viewLifecycleOwner) {
                val message = getString(R.string.snack_bar_message_success)
                snackBarMessage(message)
            }
            loading.observe(viewLifecycleOwner) {
                binding.apply {
                    if (it) {
                        loadingAnimtaion.visibility = View.VISIBLE
                        cardViewSample.visibility = View.GONE
                    } else {
                        loadingAnimtaion.visibility = View.INVISIBLE
                        cardViewSample.visibility = View.VISIBLE //Просто тестируем, если будет ошибка то должна быть другая анимашка
                    }
                }
            }
        }
    }

    //СДЕЛАТЬ АНИМАЦИЮ НА ЭКРНА ПОКА ВСЕ НЕ ПОДГРУЗИЛОСЬ И АНИМАЦИЮ ЕСЛИ ОИШБКА

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainProfileFragmentBinding {
        return MainProfileFragmentBinding.inflate(inflater, container, false)
    }

}