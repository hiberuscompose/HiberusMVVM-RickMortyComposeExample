package com.hiberus.template.data.datasources.core.remote.interfaces

interface AccessTokenProvider {
    fun token(): String
    fun refreshToken(): String
    fun cleanToken()
}
