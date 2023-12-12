package com.hiberus.template.data.datasources.features.characters

import com.hiberus.template.data.models.features.characters.remote.RemoteRickAndMortyCharacter
import com.hiberus.template.data.models.features.common.remote.RemoteRickAndMortyResult
import com.hiberus.template.core.common.entities.enums.GenderFilter
import com.hiberus.template.core.common.entities.enums.StatusFilter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RickAndMortyCharactersService {
    @GET("api/character")
    suspend fun getAllCharacters(@Query("page") currentPage: Int): Response<RemoteRickAndMortyResult<RemoteRickAndMortyCharacter>>

    @GET("api/character")
    suspend fun getFilteredCharacters(
        @Query("page") currentPage: Int,
        @Query("name") nameFilter: String = "",
        @Query("status") status: StatusFilter = StatusFilter.none,
        @Query("species") species: String = "",
        @Query("gender")gender: GenderFilter = GenderFilter.none,
    ): Response<RemoteRickAndMortyResult<RemoteRickAndMortyCharacter>>

    @GET("api/character/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: Int
    ): Response<RemoteRickAndMortyCharacter>

    @GET("api/character/{charactersId}")
    suspend fun getDiscreteCharacters(
        @Path("charactersId",encoded = false)
        charactersId: String
    ): Response<List<RemoteRickAndMortyCharacter>>
}