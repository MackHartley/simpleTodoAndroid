package com.mackhartley.simpletodo.getStarted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.authentication.storage.CredentialsManager
import com.auth0.android.authentication.storage.SharedPreferencesStorage
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.mackhartley.simpletodo.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class GetStartedFragment : Fragment() {

    private val getStartedViewModel: GetStartedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_get_started, container, false)
        val getStartedButton = view.findViewById<Button>(R.id.get_started_btn)
        getStartedButton.setOnClickListener {
//            findNavController().navigate(R.id.action_getStartedFragment_to_todoListFragment)
            initiateLoginProcess()
        }
        return view
    }

    private fun initiateLoginProcess() {
        val authAccount = getStartedViewModel.getAuthAccount()
        WebAuthProvider.login(authAccount)
            .withScheme(getString(R.string.auth_scheme))
            .withScope("openid profile email")
            .withAudience("https://simple-todo-api.mackhartley.com")
            // Launch the authentication passing the callback where the results will be received
            .start(requireContext(), object : Callback<Credentials, AuthenticationException> {
                // Called when there is an authentication failure
                override fun onFailure(exception: AuthenticationException) {
                    // Something went wrong!
                }

                // Called when authentication completed successfully
                override fun onSuccess(credentials: Credentials) {
                    getStartedViewModel.saveCredentials(credentials)
                    findNavController().navigate(R.id.login)
                }
            })
    }
}