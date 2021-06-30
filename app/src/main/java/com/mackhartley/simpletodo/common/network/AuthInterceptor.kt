package com.mackhartley.simpletodo.common.network

import com.auth0.android.authentication.storage.CredentialsManager
import com.mackhartley.simpletodo.common.CredentialsManagerCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val credentialsManager: CredentialsManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        var token: String? = null
        credentialsManager.getCredentials(
            CredentialsManagerCallback {
                token = it.accessToken
            }
        )

        val newRequest = originalRequest.newBuilder()
        if (token != null) newRequest.addHeader("Authorization", "Bearer $token")

        return chain.proceed(newRequest.build())
    }
}