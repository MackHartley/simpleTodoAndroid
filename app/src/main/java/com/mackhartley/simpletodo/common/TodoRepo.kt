package com.mackhartley.simpletodo.common

import com.mackhartley.simpletodo.TodoItem
import com.mackhartley.simpletodo.common.network.TodoService

class TodoRepo(
    private val todoService: TodoService
) {

    suspend fun getTodos(): List<TodoItem> {
        return todoService.getTodoItems()
    }

    suspend fun addTodo(todoText: String): Boolean {
        return todoService.addTodoItem(todoText)
    }

    suspend fun deleteTodo(todoId: Int): Boolean {
        return todoService.deleteTodoItem(todoId)
    }
}