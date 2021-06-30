package com.mackhartley.simpletodo.addTodo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mackhartley.simpletodo.common.TodoRepo
import kotlin.Exception

class AddTodoViewModel(private val todoRepo: TodoRepo) : ViewModel() {

    fun addTodo(newTodoText: String): LiveData<Boolean> = liveData {
        try {
            val isSuccess = todoRepo.addTodo(newTodoText)
            emit(isSuccess)
        } catch (e: Exception) {
            emit(false)
        }
    }
}