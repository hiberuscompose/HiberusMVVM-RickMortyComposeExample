package com.hiberus.template.presentation.viewmodels.common

sealed class ResourceState<T>{
    data object Idle: ResourceState<Nothing>()
    data class Loading<T> (val data: T): ResourceState<T>()
    data class Success<T> (val data: T): ResourceState<T>()
    data class Error<T: Throwable> (val data: T): ResourceState<T>()
}
