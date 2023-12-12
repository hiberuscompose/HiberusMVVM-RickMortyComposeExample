package com.hiberus.template.core.ui.authmanager.exceptions

import android.accounts.AccountManager
import android.content.Context

class UnsupportedAuthTokenTypeException(context: Context, unsupportedAuthTokenTypeResourceId: Int): AuthenticatorException(
    context,
    AccountManager.ERROR_CODE_UNSUPPORTED_OPERATION,
    unsupportedAuthTokenTypeResourceId
) {
    companion object{
        val serialVersionUUID: Long = 3L
    }
}