package com.mackhartley.simpletodo.todoList.di

import com.mackhartley.simpletodo.todoList.TodoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val todoListModule = module {
    viewModel { TodoListViewModel(get()) }
}