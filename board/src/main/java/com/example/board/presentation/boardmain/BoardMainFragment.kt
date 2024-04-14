package com.example.board.presentation.boardmain

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.board.data.datasources.api.BoardApiRepositoryImpl
import com.example.board.databinding.MainBoardFragmentBinding
import com.example.board.domain.api.usecase.UseCaseGetBoardInfo
import com.example.board.presentation.boardmain.adapter.TaskListAdapter
import com.example.board.presentation.taskscreen.BoardTaskAddFragment
import com.example.board.presentation.taskscreen.BoardTaskFragment
import com.example.board.presentation.utils.SharedPreferencesBoard
import com.example.core.base.dialog.snackBarErrorMessage
import com.example.core.base.fragment.BaseFragment
import com.example.database.models.board.Task
import com.example.response.TaskResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class BoardMainFragment(context: Context) :
    BaseFragment<MainBoardFragmentBinding, BoardMainFragmentViewModel>(
        BoardMainFragmentViewModel::class,
        BoardMainFragmentViewModelFactory(context)
    ) {

    private val listOfTask = mutableListOf<TaskResponse>()
    private var isSearching = false
    private lateinit var sharedPR: SharedPreferencesBoard
    private val adapter = TaskListAdapter()
    var callbackFragment: ((Fragment) -> Unit)? = null
    override fun setUpViews() {
        binding.apply {
            setupRecyclerView(this)
            searchViewTaskTitle.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText == null) {
                        isSearching = false
                        return false
                    }
                    return if (newText.isNotEmpty()) {
                        isSearching = true
                        val filteredList = listOfTask.filter {
                            it.title.contains(newText)
                        }
                        adapter.submitList(filteredList)
                        true
                    } else {
                        adapter.submitList(listOfTask)
                        false
                    }
                }

            })
        }
        binding.buttonAdd.setOnClickListener {
            val fragment = BoardTaskAddFragment.newInstance()
            callbackFragment?.invoke(fragment)
        }
    }

    private fun setupRecyclerView(binding: MainBoardFragmentBinding) {
        binding.apply {
            recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewTask.adapter = adapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.startGettingBoardInfo(1)
        sharedPR = SharedPreferencesBoard(requireContext())
        observableEvents()
        adapter.clickListener = {
            val fragment = BoardTaskFragment.newInstance(it)
            callbackFragment?.invoke(fragment)
        }
        sharedPR.setIdData(1)
    }

    private fun observableEvents() {
        viewModel.apply {
            dataBoard.observe(viewLifecycleOwner) {
                listOfTask.clear()
                listOfTask.addAll(it.tasks)
                if (!isSearching) {
                    adapter.submitList(it.tasks)
                }
                //В зависимости от выбранной доски будет храниться нужное значение

            }
            loading.observe(viewLifecycleOwner) {
                if (it) {
                    binding.loadingAnimtaion.visibility = View.VISIBLE
                } else {
                    binding.loadingAnimtaion.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): MainBoardFragmentBinding {
        return MainBoardFragmentBinding.inflate(inflater, container, false)
    }

    companion object {
        fun newInstance(context: Context): BoardMainFragment {
            return BoardMainFragment(context)
        }
    }

}