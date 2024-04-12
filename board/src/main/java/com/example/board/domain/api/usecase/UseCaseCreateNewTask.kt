package com.example.board.domain.api.usecase

import com.example.board.domain.api.BoardApiRepository
import com.example.database.models.board.Task
import kotlinx.coroutines.flow.flow

class UseCaseCreateNewTask(private val apiRepository: BoardApiRepository){

    operator fun invoke(task: Task) = flow {
        emit(apiRepository.insertNewTask(task))
    }
}