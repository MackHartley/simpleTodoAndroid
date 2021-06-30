package com.mackhartley.simpletodo.addTodo.di

import com.mackhartley.simpletodo.addTodo.AddTodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addTodoModule = module {
    viewModel { AddTodoViewModel(get()) }
}