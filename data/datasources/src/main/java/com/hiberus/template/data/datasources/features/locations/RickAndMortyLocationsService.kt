package com.hiberus.template.data.datasources.features.locations

import com.hiberus.template.data.models.features.common.remote.RemoteRickAndMortyResult
import com.hiberus.template.data.models.features.locations.remote.RemoteRickAndMortyLocation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyLocationsService {
    @GET("api/location")
    suspend fun getAllLocations(
        @Query("page") currentPage: Int
    ): Response<RemoteRickAndMortyResult<RemoteRickAndMortyLocation>>

    @GET("api/location")
    suspend fun getFilteredLocations(
        @Query("page") currentPage: Int,
        @Query("name") nameFilter: String = "",
        @Query("type") type: String = "",
        @Query("dimension") dimension: String = ""
    ): Response<RemoteRickAndMortyResult<RemoteRickAndMortyLocation>>

    @GET("api/location/{locationId}")
    suspend fun getLocationById(
        @Path("locationId") locationId: Int
    ): Response<RemoteRickAndMortyLocation>

    @GET("api/location/{locationsId}")
    suspend fun getDiscreteLocations(
        @Query("page") currentPage: Int,
        @Path("locationsId",encoded = false)
        locationsId: String
    ): Response<List<RemoteRickAndMortyLocation>>
}