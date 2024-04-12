package com.example.board.domain.api.usecase

import com.example.board.domain.api.BoardApiRepository
import kotlinx.coroutines.flow.flow

class UseCaseDeleteTask(private val repository: BoardApiRepository) {

    operator fun invoke(taskId: Int) = flow {
        emit(repository.deleteTask(taskId))
    }
}