package com.wiryadev.siavounj.ui.screens.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.wiryadev.siavounj.ui.theme.SiavoUNJTheme

class SignUpFragment : Fragment() {

    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                SiavoUNJTheme {
                    SignUpScreen(
                        onSignUpSubmitted = viewModel::signUp,
                    )
                }
            }
        }
    }
}