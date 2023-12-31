package com.hiberus.template.data.datasources.core.remote.interceptors

import com.hiberus.template.data.datasources.core.remote.interfaces.AccessTokenProvider
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AccessTokenInterceptor @Inject constructor(
    private val tokenProvider: AccessTokenProvider
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = tokenProvider.token()
        val refreshToken = tokenProvider.refreshToken()
        // TODO Make actions for token refresh
        return if (token == "") {
            chain.proceed(chain.request())
        } else {
            val authenticatedRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", "bearer $token")
                .build()
            chain.proceed(authenticatedRequest)
        }
    }
}
