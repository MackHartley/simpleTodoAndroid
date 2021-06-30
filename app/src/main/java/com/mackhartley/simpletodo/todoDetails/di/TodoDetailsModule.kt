package com.mackhartley.simpletodo.todoDetails.di

import com.mackhartley.simpletodo.todoDetails.TodoDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val todoDetailsModule = module {
    viewModel { TodoDetailsViewModel(get()) }
}