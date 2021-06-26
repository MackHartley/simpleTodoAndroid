package com.mackhartley.simpletodo.todoList.di

import com.mackhartley.simpletodo.todoList.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val todoListModule = module {
    viewModel { TodoViewModel(get(), get()) }
}