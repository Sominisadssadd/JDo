package com.example.board.presentation.boardmain

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.board.data.datasources.api.BoardApiRepositoryImpl
import com.example.board.domain.api.usecase.UseCaseGetBoardInfo
import com.example.board.domain.api.usecase.UseCaseGetBoardList
import com.example.database.models.board.Board
import com.example.database.models.board.BoardInfo
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class BoardMainFragmentViewModel(context: Context) : ViewModel() {


    private val repositoryImpl = BoardApiRepositoryImpl()

    private val useCaseGetBoardInfo = UseCaseGetBoardInfo(repositoryImpl)
    private val useCaseGetListBoard = UseCaseGetBoardList(repositoryImpl)

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _dataBoard = MutableLiveData<BoardInfo>()
    val dataBoard: LiveData<BoardInfo>
        get() = _dataBoard


    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading


    fun setLoadingStatus(isLoading: Boolean) {
        _loading.value = isLoading
    }

    fun sendError(message: String) {
        _error.value = message
    }

    fun pudDataBoard(board: BoardInfo) {
        _dataBoard.value = board
    }

    fun startGettingBoardInfo(boardId: Int) {
        useCaseGetBoardInfo.invoke(boardId)
            .onEach {
                pudDataBoard(it.data!!)
            }
            .catch {
                sendError(it.message.toString())

            }
            .launchIn(viewModelScope)
    }

    suspend fun getBoardList(userId: Int): List<Board>? {
        val result = viewModelScope.async {
            return@async useCaseGetListBoard(userId)
        }.await()
        return result.data
    }
}