package com.wiryadev.siavounj.ui.components.textfield

import android.util.Patterns

class EmailState : TextFieldState(validator = ::isEmailValid,)

private fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

val EmailStateSaver = textFieldStateSaver(EmailState())