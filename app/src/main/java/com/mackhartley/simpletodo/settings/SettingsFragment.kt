package com.mackhartley.simpletodo.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.mackhartley.simpletodo.R
import com.mackhartley.simpletodo.common.ext.showError
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsFragment : Fragment() {

    private val settingsViewModel: SettingsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        val logOutBtn = view.findViewById<Button>(R.id.log_out_btn)
        logOutBtn.setOnClickListener { logout() }

        return view
    }

    private fun logout() {
        WebAuthProvider.logout(settingsViewModel.getAuthAccount())
            .withScheme(getString(R.string.auth_scheme))
            .start(requireContext(), object: Callback<Void?, AuthenticationException> {
                override fun onSuccess(payload: Void?) {
                    settingsViewModel.clearSavedCredentials()
                    findNavController().navigate(R.id.action_settingsFragment_to_getStartedFragment)
                }
                override fun onFailure(error: AuthenticationException) {
                    showError()
                }
            })
    }
}