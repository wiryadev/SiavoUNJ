package com.wiryadev.siavounj.ui.screens.auth.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wiryadev.siavounj.R
import com.wiryadev.siavounj.ui.components.AuthHeader
import com.wiryadev.siavounj.ui.components.textfield.*
import com.wiryadev.siavounj.ui.theme.body3
import com.wiryadev.siavounj.ui.theme.body3Bold

@Composable
fun LoginScreen(
    onLoginSubmitted: (email: String, password: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var showBranding by remember { mutableStateOf(true) }
    
    Scaffold(
        modifier = modifier
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(56.dp))
                AnimatedVisibility(visible = showBranding){
                    AuthHeader(
                        bodyText = stringResource(R.string.login_body_title),
                        hintText = stringResource(R.string.login_hint_subtitle),
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                LoginContent(
                    onFocusChange = { focused -> showBranding = !focused},
                    onLoginSubmitted = onLoginSubmitted,
                )
            }
        }
    }
}

@Composable
fun LoginContent(
    onFocusChange: (Boolean) -> Unit,
    onLoginSubmitted: (email: String, password: String) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val focusRequester = remember { FocusRequester() }
        val emailState by rememberSaveable(stateSaver = EmailStateSaver) {
            mutableStateOf(EmailState())
        }
        EmailTextField(emailState, onImeAction = { focusRequester.requestFocus() })

        Spacer(modifier = Modifier.height(16.dp))

        val passwordState = remember { PasswordState() }

        val onSubmit = {
            if (emailState.isValid && passwordState.isValid) {
                onLoginSubmitted(emailState.text, passwordState.text)
            }
        }
        PasswordTextField(
            label = stringResource(id = R.string.password),
            passwordState = passwordState,
            modifier = Modifier.focusRequester(focusRequester),
            onImeAction = { onSubmit() }
        )
        onFocusChange(emailState.isFocused || passwordState.isFocused)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(R.string.forgot_password),
            style = body3Bold,
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = { onSubmit() },
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.dont_have_account),
                style = body3,
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = stringResource(R.string.sign_up),
                style = body3Bold.copy(
                    color = MaterialTheme.colors.primary,
                ),
            )
        }
    }
}