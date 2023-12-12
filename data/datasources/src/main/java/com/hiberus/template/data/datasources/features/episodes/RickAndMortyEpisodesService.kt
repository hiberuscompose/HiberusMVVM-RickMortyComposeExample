package com.hiberus.template.data.datasources.features.episodes

import com.hiberus.template.data.models.features.common.remote.RemoteRickAndMortyResult
import com.hiberus.template.data.models.features.episodes.remote.RemoteRickAndMortyEpisode
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyEpisodesService {
    @GET("api/episode")
    suspend fun getAllEpisodes(
        @Query("page") currentPage: Int
    ): Response<RemoteRickAndMortyResult<RemoteRickAndMortyEpisode>>

    @GET("api/episode")
    suspend fun getFilteredEpisodes(
        @Query("page") currentPage: Int,
        @Query("name") nameFilter: String = "",
        @Query("episode") episodeCode: String = ""
    ): Response<RemoteRickAndMortyResult<RemoteRickAndMortyEpisode>>

    @GET("api/episode/{episodeId}")
    suspend fun getEpisodeById(
        @Path("episodeId") episodeId: Int
    ): Response<RemoteRickAndMortyEpisode>

    @GET("api/episode/{episodesId}")
    suspend fun getDiscreteEpisodes(
        @Query("page") currentPage: Int,
        @Path("episodesId",encoded = false)
        episodesId: String
    ): Response<List<RemoteRickAndMortyEpisode>>
}