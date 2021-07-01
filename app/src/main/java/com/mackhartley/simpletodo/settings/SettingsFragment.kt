package com.mackhartley.simpletodo.settings

import android.content.Intent
import android.net.Uri
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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

        val about = view.findViewById<View>(R.id.about)
        val privacy = view.findViewById<View>(R.id.privacy)
        val terms = view.findViewById<View>(R.id.terms)

        about.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(getString(R.string.about))
                .setMessage(getString(R.string.about_txt))
                .setNegativeButton(getString(R.string.close)) { _, _ -> }
                .setPositiveButton(getString(R.string.visit_github)) { _, _ ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/MackHartley/simpleTodoAndroid"))
                    startActivity(intent)
                }
                .show()
        }
        privacy.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/simpletodo-privacypolicy/home"))
            startActivity(intent)
        }
        terms.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/simpletodotc/home"))
            startActivity(intent)
        }

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