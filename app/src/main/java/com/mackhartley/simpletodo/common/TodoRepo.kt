package com.mackhartley.simpletodo.common

import com.mackhartley.simpletodo.TodoItem

class TodoRepo {
    fun getData() = List<TodoItem>(100) { TodoItem(it, "Item number ${it+1}")}
}