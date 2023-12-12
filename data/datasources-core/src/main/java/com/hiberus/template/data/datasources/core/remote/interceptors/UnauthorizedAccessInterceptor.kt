package com.hiberus.template.data.datasources.core.remote.interceptors

import com.hiberus.template.data.datasources.core.remote.interfaces.AccessTokenProvider
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.internal.http.HTTP_FORBIDDEN
import okhttp3.internal.http.HTTP_UNAUTHORIZED
import javax.inject.Inject

class UnauthorizedAccessInterceptor @Inject constructor(
    private val tokenProvider: AccessTokenProvider
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (response.code == HTTP_UNAUTHORIZED || response.code == HTTP_FORBIDDEN) {
            tokenProvider.cleanToken()
        }
        return response
    }
}
