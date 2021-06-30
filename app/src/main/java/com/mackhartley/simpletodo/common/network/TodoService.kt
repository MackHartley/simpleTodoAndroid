package com.mackhartley.simpletodo.common.network

import com.mackhartley.simpletodo.TodoItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TodoService {

    @GET("getTodos/Test")
    suspend fun getTodoItems(): List<TodoItem>

    @POST("addTodo/Test")
    suspend fun addTodoItem(@Body newTodoText: String): Boolean

    @POST("deleteTodo")
    suspend fun deleteTodoItem(@Body todoId: Int): Boolean
}