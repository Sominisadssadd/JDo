package com.example.board.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.board.databinding.BoardBaseFragmentBinding
import com.example.board.presentation.boardmain.BoardMainFragment
import com.example.core.base.fragment.BaseFragment

class BoardBaseFragment : BaseFragment<BoardBaseFragmentBinding, BoardBaseFragmentViewModel>(
    BoardBaseFragmentViewModel::class,
    null
) {

    override fun setUpViews() {

    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): BoardBaseFragmentBinding {
        return BoardBaseFragmentBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragment = BoardMainFragment.newInstance(requireContext()).apply {
            callbackFragment = {
                navigateTo(it)
            }
        }
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(binding.boardFrameLayout.id, fragment)
            .commit()
    }

    private fun navigateTo(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(binding.boardFrameLayout.id, fragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun newInstance() = BoardBaseFragment()
    }
}