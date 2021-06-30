package com.mackhartley.simpletodo.todoList

import androidx.lifecycle.*
import com.mackhartley.simpletodo.TodoItem
import com.mackhartley.simpletodo.common.TodoRepo

class TodoListViewModel(
    private val todoRepo: TodoRepo
) : ViewModel() {
    private val loadTrigger = MutableLiveData(Unit)
    fun refreshData() {
        loadTrigger.value = Unit
    }

    val todoList: LiveData<List<TodoItem>?> = loadTrigger.switchMap {
        requestTodoListData()
    }

    private fun requestTodoListData(): LiveData<List<TodoItem>?> = liveData {
        try {
            val data = todoRepo.getTodos()
            emit(data)
        } catch (e: Exception) {
            emit(null)
        }
    }
}