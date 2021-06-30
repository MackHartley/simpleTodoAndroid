package com.mackhartley.simpletodo.todoDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mackhartley.simpletodo.common.TodoRepo

class TodoDetailsViewModel(
    private val todoRepo: TodoRepo
) : ViewModel() {
    fun deleteTodo(todoId: Int): LiveData<Boolean> = liveData {
        try {
            val isSuccess = todoRepo.deleteTodo(todoId)
            emit(isSuccess)
        } catch (e: Exception) {
            emit(false)
        }
    }
}