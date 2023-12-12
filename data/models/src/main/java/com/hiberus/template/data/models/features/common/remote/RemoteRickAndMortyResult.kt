package com.hiberus.template.data.models.features.common.remote

import com.google.gson.annotations.SerializedName

data class RemoteRickAndMortyResult<T>(
    @SerializedName("info") val info: RemoteRickAndMortyInfo,
    @SerializedName("results") val results: List<T>
)