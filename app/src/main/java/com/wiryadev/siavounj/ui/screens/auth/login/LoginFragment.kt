package com.wiryadev.siavounj.ui.screens.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.screens.MainActivity
import com.wiryadev.siavounj.ui.theme.SiavoUNJTheme

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                SiavoUNJTheme {
                    LoginScreen(
                        onLoginSubmitted = viewModel::login,
                        onSignUpClicked = ::onSignUpClicked,
                    )
                }
            }
        }
    }

    private fun onSignUpClicked() {
        findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
    }
}