package com.mackhartley.simpletodo.todoList

import androidx.lifecycle.ViewModel
import com.auth0.android.Auth0
import com.mackhartley.simpletodo.common.TodoRepo

class TodoViewModel(
    private val todoRepo: TodoRepo,
    private val auth0: Auth0
    ) : ViewModel() {

    fun getTodos() = todoRepo.getData()
    fun getAuthAccount() = auth0
}