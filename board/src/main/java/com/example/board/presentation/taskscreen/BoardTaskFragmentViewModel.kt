package com.example.board.presentation.taskscreen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.board.data.datasources.api.BoardApiRepositoryImpl
import com.example.board.domain.api.usecase.UseCaseCreateNewTask
import com.example.board.domain.api.usecase.UseCaseDeleteTask
import com.example.board.domain.api.usecase.UseCaseGetBoardInfo
import com.example.board.domain.api.usecase.UseCaseGetBoardList
import com.example.board.domain.api.usecase.UseCaseUpdateTask
import com.example.database.models.board.BoardInfo
import com.example.database.models.board.Task
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class BoardTaskFragmentViewModel : ViewModel() {


    private val repositoryImpl = BoardApiRepositoryImpl()

    private val useCaseUpdateTask = UseCaseUpdateTask(repositoryImpl)
    private val useCaseDeleteTask = UseCaseDeleteTask(repositoryImpl)

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _data = MutableLiveData<String>()
    val data: LiveData<String>
        get() = _data


    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading


    fun setLoadingStatus(isLoading: Boolean) {
        _loading.value = isLoading
    }

    fun sendError(message: String) {
        _error.value = message
    }

    fun pudData(message: String) {
        _data.value = message
    }

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean>
        get() = _success

    fun successTrue() {
        _success.value = true
    }

    fun updateTask(task: Task) {
        useCaseUpdateTask(task)
            .onEach {
                if (it.success) {
                    successTrue()
                } else {
                  pudData("Обновленно!")
                }
            }
            .catch {
                sendError(it.message.toString())
            }
            .launchIn(viewModelScope)
    }

    fun deleteTask(taskId: Int) {
        useCaseDeleteTask(taskId)
            .onEach {
                if (it.success) {
                    successTrue()
                } else {
                    pudData("Удаленно!")
                }
            }
            .catch {
                sendError(it.message.toString())
            }
            .launchIn(viewModelScope)
    }


}