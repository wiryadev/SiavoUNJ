package com.wiryadev.siavounj.ui.components.textfield

class PasswordState : TextFieldState(validator = ::isPasswordValid)

class ConfirmPasswordState(
    private val passwordState: PasswordState,
) : TextFieldState() {
    override val isValid
        get() = passwordAndConfirmationValid(passwordState.text, text)
}

private fun passwordAndConfirmationValid(password: String, confirmedPassword: String): Boolean {
    return isPasswordValid(password) && password == confirmedPassword
}

private fun isPasswordValid(password: String): Boolean {
    return password.length > 6
}