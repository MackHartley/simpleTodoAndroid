package com.mackhartley.simpletodo.settings

import androidx.lifecycle.ViewModel
import com.auth0.android.Auth0
import com.auth0.android.authentication.storage.CredentialsManager

class SettingsViewModel(
    private val authAccount: Auth0,
    private val credentialsManager: CredentialsManager
) : ViewModel() {
    fun getCurrentAccountEmail(): String = "example@gmail.com"
    fun getAuthAccount(): Auth0 = authAccount
    fun clearSavedCredentials() {
        credentialsManager.clearCredentials()
    }
}