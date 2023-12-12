package com.hiberus.template.core.common.entities

import android.accounts.Account
import android.accounts.AccountManager
import android.content.Context
import android.util.Base64
import com.google.gson.GsonBuilder

open class AuthUser(
    val login: String = "",
    val password: String = "",
    val userName: String = "",
    val isCreator: Boolean = false,
    val defaultUser: Boolean = false,
) {
    override fun toString(): String = this.userName
    companion object{
        inline fun <reified T: AuthUser>fromAccount(context: Context, account: Account): T? {
            try {
                val manager = AccountManager.get(context)
                val accountData = Base64.decode(manager.getPassword(account), Base64.DEFAULT)
                return GsonBuilder().create().fromJson(String(accountData), T::class.java)
            }catch (_: Exception){

            }

            return null
        }
    }

}