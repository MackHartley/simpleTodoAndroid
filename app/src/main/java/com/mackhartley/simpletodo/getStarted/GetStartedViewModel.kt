package com.mackhartley.simpletodo.getStarted

import androidx.lifecycle.ViewModel
import com.auth0.android.Auth0
import com.auth0.android.authentication.storage.CredentialsManager
import com.auth0.android.result.Credentials

class GetStartedViewModel(
    private val account: Auth0,
    private val credentialsManager: CredentialsManager
    ) : ViewModel() {

    fun getAuthAccount() = account

    fun saveCredentials(newCredentials: Credentials) {
        credentialsManager.saveCredentials(newCredentials)
    }
}