package com.example.board.domain.api.usecase

import com.example.board.data.datasources.api.response.BoardResultResponse
import com.example.board.domain.api.BoardApiRepository
import com.example.database.models.board.Board
import kotlinx.coroutines.flow.flow

class UseCaseGetBoardList(private val apiRepository: BoardApiRepository) {
    suspend operator fun invoke(userId: Int) : BoardResultResponse<List<Board>>{
        return apiRepository.getBoardList(userId)
    }
}