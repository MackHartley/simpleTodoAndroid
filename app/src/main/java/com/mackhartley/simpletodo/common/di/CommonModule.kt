package com.mackhartley.simpletodo.common.di

import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.storage.CredentialsManager
import com.auth0.android.authentication.storage.SharedPreferencesStorage
import com.mackhartley.simpletodo.R
import com.mackhartley.simpletodo.common.TodoRepo
import com.mackhartley.simpletodo.common.network.TodoRetrofitConfigs.baseUrl
import com.mackhartley.simpletodo.common.network.TodoService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val commonModule = module {
    single<TodoRepo> { TodoRepo() }
    single<Auth0> {
        Auth0(
            androidContext().getString(R.string.clientId),
            androidContext().getString(R.string.com_auth0_domain)
        )
    }
    single<TodoService> {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofitInstance = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInstance.create(TodoService::class.java)
    }
    single<AuthenticationAPIClient> {
        val authAccount: Auth0 = get()
        AuthenticationAPIClient(authAccount)
    }
    single<SharedPreferencesStorage> {
        SharedPreferencesStorage(androidContext())
    }
    single<CredentialsManager>{
        val authApiClient: AuthenticationAPIClient = get()
        val sharedPrefsStorage: SharedPreferencesStorage = get()
        CredentialsManager(authApiClient, sharedPrefsStorage)
    }
}