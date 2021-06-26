package com.mackhartley.simpletodo.getStarted.di

import com.mackhartley.simpletodo.getStarted.GetStartedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val getStartedModule = module {
    viewModel { GetStartedViewModel(get(), get()) }
}