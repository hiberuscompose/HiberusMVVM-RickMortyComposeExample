package com.hiberus.template.core.ui.authmanager.exceptions

import android.accounts.AccountManager
import android.content.Context

class UnsupportedFeaturesException(context: Context, unsupportedFeaturesResourceId: Int): AuthenticatorException(
    context,
    AccountManager.ERROR_CODE_UNSUPPORTED_OPERATION,
    unsupportedFeaturesResourceId
) {
    companion object{
        val serialVersionUUID: Long = 4L
    }
}