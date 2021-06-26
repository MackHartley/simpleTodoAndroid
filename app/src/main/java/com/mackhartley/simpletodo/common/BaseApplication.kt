package com.mackhartley.simpletodo.common

import android.app.Application
import com.mackhartley.simpletodo.common.di.commonModule
import com.mackhartley.simpletodo.getStarted.di.getStartedModule
import com.mackhartley.simpletodo.todoDetails.di.todoDetailsModule
import com.mackhartley.simpletodo.todoList.di.todoListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(commonModule, getStartedModule, todoListModule, todoDetailsModule)
        }
    }
}