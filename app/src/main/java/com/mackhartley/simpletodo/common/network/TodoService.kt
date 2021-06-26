package com.mackhartley.simpletodo.common.network

import com.mackhartley.simpletodo.TodoItem
import com.mackhartley.simpletodo.common.models.NewTodoItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface TodoService {

    @GET("getTodos/Test")
    suspend fun getTodoItems(@Header("Authorization") token: String): List<TodoItem>

//    @POST("addTodo")
//    fun addTodoItem(@Body newTodoText: String)
}