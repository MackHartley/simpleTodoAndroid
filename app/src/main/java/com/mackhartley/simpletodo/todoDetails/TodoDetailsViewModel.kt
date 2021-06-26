package com.mackhartley.simpletodo.todoDetails

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.auth0.android.authentication.storage.CredentialsManager
import com.auth0.android.authentication.storage.CredentialsManagerException
import com.auth0.android.callback.BaseCallback
import com.auth0.android.callback.Callback
import com.auth0.android.result.Credentials
import com.mackhartley.simpletodo.common.network.TodoService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class TodoDetailsViewModel(
    private val todoService: TodoService,
    private val credentialsManager: CredentialsManager
) : ViewModel() {
    fun addTodo(newTodoText: String) {
//        todoService.addTodoItem(newTodoText)
    }

    suspend fun getTodos(credentials: Credentials) {
        val authHeaderValue = "Bearer ${credentials.accessToken}"
        todoService.getTodoItems(authHeaderValue)
    }

    fun makecall() {
        credentialsManager.getCredentials(object : Callback<Credentials, CredentialsManagerException> {
            override fun onSuccess(result: Credentials) {
                CoroutineScope(IO).launch {
                    getTodos(result)
                }
            }

            override fun onFailure(error: CredentialsManagerException) {
                TODO("Not yet implemented")
            }

        })
//        credentialsManager.getCredentials(
//            object :
//                BaseTransientBottomBar.BaseCallback<Credentials, CredentialsManagerException>() {
//
//            }
//        )
    }
}