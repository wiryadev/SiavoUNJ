package com.wiryadev.siavounj.ui.screens.auth.register

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.components.AuthHeader
import com.wiryadev.siavounj.ui.components.textfield.*
import com.wiryadev.siavounj.ui.screens.LoginSignUpScreen

@Composable
fun SignUpScreen(
    onSignUpSubmitted: (email: String, password: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var showBranding by remember { mutableStateOf(true) }

    LoginSignUpScreen(
        showBranding = showBranding,
        modifier = modifier,
        header = {
            AuthHeader(
                bodyText = stringResource(R.string.sign_up_body_title),
            )
        },
        content = {
            SignUpContent(
                onFocusChange = { focused -> showBranding = !focused },
                onSignUpSubmitted = onSignUpSubmitted,
            )
        },
    )
}

@Composable
fun SignUpContent(
    onFocusChange: (Boolean) -> Unit,
    onSignUpSubmitted: (email: String, password: String) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val passwordFocusRequest = remember { FocusRequester() }
        val confirmationPasswordFocusRequest = remember { FocusRequester() }

        val emailState = remember { EmailState() }
        EmailTextField(emailState, onImeAction = { passwordFocusRequest.requestFocus() })
        Spacer(modifier = Modifier.height(16.dp))

        val passwordState = remember { PasswordState() }
        PasswordTextField(
            label = stringResource(id = R.string.password),
            passwordState = passwordState,
            imeAction = ImeAction.Next,
            onImeAction = { confirmationPasswordFocusRequest.requestFocus() },
            modifier = Modifier.focusRequester(passwordFocusRequest),
        )
        Spacer(modifier = Modifier.height(16.dp))

        val confirmPasswordState = remember { ConfirmPasswordState(passwordState = passwordState) }
        PasswordTextField(
            label = stringResource(id = R.string.confirm_password),
            passwordState = confirmPasswordState,
            onImeAction = { onSignUpSubmitted(emailState.text, passwordState.text) },
            modifier = Modifier.focusRequester(confirmationPasswordFocusRequest)
        )
        onFocusChange(emailState.isFocused || passwordState.isFocused || confirmPasswordState.isFocused)

        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = { onSignUpSubmitted(emailState.text, passwordState.text) },
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 16.dp),
            enabled = emailState.isValid && passwordState.isValid,
        ) {
            Text(
                text = stringResource(id = R.string.login)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}