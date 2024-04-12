package com.example.board.domain.api.usecase

import com.example.board.domain.api.BoardApiRepository
import com.example.database.models.board.BoardInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UseCaseGetBoardInfo(private val apiRepository: BoardApiRepository) {

    operator fun invoke(boardId: Int) = flow {
        while (true) {
            emit(apiRepository.getBoardInfo(boardId))
            delay(5000)
        }
    }.flowOn(Dispatchers.Default)

}