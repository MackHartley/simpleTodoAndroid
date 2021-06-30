package com.mackhartley.simpletodo.common

import android.util.Log
import com.auth0.android.authentication.storage.CredentialsManagerException
import com.auth0.android.callback.Callback
import com.auth0.android.result.Credentials

class CredentialsManagerCallback(
    private val onSuccessCallback: (Credentials) -> Unit
) : Callback<Credentials, CredentialsManagerException> {

    companion object {
        private const val ERROR_TAG = "CredManagerCallback"
    }

    override fun onSuccess(result: Credentials) {
        onSuccessCallback(result)
    }

    override fun onFailure(error: CredentialsManagerException) {
        Log.e(ERROR_TAG, "CredentialsManagerCallback encountered an error: $error")
    }
}