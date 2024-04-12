package com.example.board.domain.api

import com.example.board.data.datasources.api.response.BoardResponseMessage
import com.example.board.data.datasources.api.response.BoardResultResponse
import com.example.board.data.utils.GET_BOARD_INFO_REQUEST
import com.example.board.data.utils.GET_BOARD_LIST
import com.example.board.data.utils.POST_INSERT_TASK
import com.example.board.data.utils.POST_UPDATE_TASK
import com.example.database.models.board.Board
import com.example.database.models.board.BoardInfo
import com.example.database.models.board.Task
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BoardApiRepository {

    suspend fun getBoardInfo(boardId: Int): BoardResultResponse<BoardInfo>

    suspend fun getBoardList(userId: Int): BoardResultResponse<List<Board>>

    suspend fun insertNewTask(task: Task): BoardResponseMessage

    suspend fun updateTask(task: Task): BoardResponseMessage

    suspend fun deleteTask(idTask: Int): BoardResponseMessage
}