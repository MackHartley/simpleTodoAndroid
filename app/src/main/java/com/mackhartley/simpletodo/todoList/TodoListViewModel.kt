package com.mackhartley.simpletodo.todoList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.auth0.android.Auth0
import com.mackhartley.simpletodo.TodoItem
import com.mackhartley.simpletodo.common.TodoRepo

class TodoListViewModel(
    private val todoRepo: TodoRepo
) : ViewModel() {
    val todoList: LiveData<List<TodoItem>> = liveData {
        val data = todoRepo.getTodos()
        emit(data)
    }
}