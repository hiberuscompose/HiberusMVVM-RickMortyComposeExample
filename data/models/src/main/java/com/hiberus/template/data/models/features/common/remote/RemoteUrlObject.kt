package com.hiberus.template.data.models.features.common.remote

import com.google.gson.annotations.SerializedName

data class RemoteUrlObject(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)