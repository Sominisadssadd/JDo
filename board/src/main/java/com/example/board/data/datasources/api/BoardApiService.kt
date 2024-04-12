package com.example.board.data.datasources.api

import com.example.board.data.datasources.api.response.BoardResponseMessage
import com.example.board.data.datasources.api.response.BoardResultResponse
import com.example.board.data.utils.DELETE_BOARD_TASK
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

interface BoardApiService {
    @GET(GET_BOARD_INFO_REQUEST)
    suspend fun getBoardInfo(@Path("boardId") boardId: Int): BoardResultResponse<BoardInfo>

    @GET(GET_BOARD_LIST)
    suspend fun getBoardList(@Path("userId") userId: Int): BoardResultResponse<List<Board>>

    @GET(DELETE_BOARD_TASK)
    suspend fun deleteTask(@Path("taskId") taskId: Int): BoardResponseMessage

    @POST(POST_INSERT_TASK)
    suspend fun insertNewTask(@Body task: Task): BoardResponseMessage

    @POST(POST_UPDATE_TASK)
    suspend fun updateTask(@Body task: Task): BoardResponseMessage

}