package com.example.board.data.datasources.api

import com.example.board.data.datasources.api.response.BoardResponseMessage
import com.example.board.data.datasources.api.response.BoardResultResponse
import com.example.board.domain.api.BoardApiRepository
import com.example.database.models.board.Board
import com.example.database.models.board.BoardInfo
import com.example.database.models.board.Task

class BoardApiRepositoryImpl : BoardApiRepository {

    val api = BoardRetrofitInstance.apiService
    override suspend fun getBoardInfo(boardId: Int): BoardResultResponse<BoardInfo> {
        return api.getBoardInfo(boardId)
    }

    override suspend fun getBoardList(userId: Int): BoardResultResponse<List<Board>> {
        return api.getBoardList(userId)
    }

    override suspend fun insertNewTask(task: Task): BoardResponseMessage {
        return api.insertNewTask(task)
    }

    override suspend fun updateTask(task: Task): BoardResponseMessage {
        return api.updateTask(task)
    }

    override suspend fun deleteTask(idTask: Int): BoardResponseMessage {
        return api.deleteTask(idTask)
    }
}