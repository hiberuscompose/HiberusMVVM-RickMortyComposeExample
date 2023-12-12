package com.hiberus.template.data.models.features.characters.remote

import com.google.gson.annotations.SerializedName
import com.hiberus.template.data.models.features.common.remote.RemoteUrlObject
import java.util.Date

data class RemoteRickAndMortyCharacter(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: RemoteUrlObject,
    @SerializedName("location")
    val location: RemoteUrlObject,
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: Date
)
