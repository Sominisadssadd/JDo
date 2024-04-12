package com.example.board.presentation.taskscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.board.data.datasources.api.BoardApiRepositoryImpl
import com.example.board.domain.api.usecase.UseCaseCreateNewTask
import com.example.database.models.board.Task
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class BoardAddFragmentViewModel : ViewModel() {

    val repositoryImpl = BoardApiRepositoryImpl()
    val useCaseCreateNewTask = UseCaseCreateNewTask(repositoryImpl)

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun sendError(message: String) {
        _error.value = message
    }

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean>
        get() = _success

    fun successTrue() {
        _success.value = true
    }

    fun createNewTask(task: Task) {
        useCaseCreateNewTask(task)
            .onEach {
                if (it.success) {
                    successTrue()
                } else {
                    sendError("Не успешно")
                }
            }
            .catch {
                sendError(it.message.toString())
            }
            .launchIn(viewModelScope)
    }

}