package com.hiberus.template.data.datasources.core.di

import android.content.Context
import com.hiberus.template.data.datasources.core.remote.common.RestService
import com.hiberus.template.data.datasources.core.remote.interfaces.AccessTokenProvider
import com.hiberus.template.data.datasources.core.remote.providers.AccessTokenProviderImpl
import com.hiberus.template.data.datasources.core.settings.PreferencesDataStore
import com.hiberus.template.data.datasources.features.characters.RickAndMortyCharactersService
import com.hiberus.template.data.datasources.features.episodes.RickAndMortyEpisodesService
import com.hiberus.template.data.datasources.features.locations.RickAndMortyLocationsService
import com.hiberus.template.data.datasources.features.settings.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatasourcesCoreDependencyInjector {

    @Singleton
    @Provides
    fun providesPreferences(@ApplicationContext context: Context): Preferences = PreferencesDataStore(context)

    @Provides
    fun providesAccessToken(): AccessTokenProvider = AccessTokenProviderImpl()

    @Singleton
    @Provides
    fun providesCharactersServiceRetrofit(): RickAndMortyCharactersService = Retrofit.Builder()
        .baseUrl(
            RestService.BASE_API
        )
        .addConverterFactory(GsonConverterFactory.create(RestService.makeGson()))
        .client(RestService.makeOkHttpClient())
        .build().create(RickAndMortyCharactersService::class.java)

    @Singleton
    @Provides
    fun providesEpisodesServiceRetrofit(): RickAndMortyEpisodesService = Retrofit.Builder()
        .baseUrl(
            RestService.BASE_API
        )
        .addConverterFactory(GsonConverterFactory.create(RestService.makeGson()))
        .client(RestService.makeOkHttpClient())
        .build().create(RickAndMortyEpisodesService::class.java)

    @Singleton
    @Provides
    fun providesLocationsServiceRetrofit(): RickAndMortyLocationsService = Retrofit.Builder()
        .baseUrl(
            RestService.BASE_API
        )
        .addConverterFactory(GsonConverterFactory.create(RestService.makeGson()))
        .client(RestService.makeOkHttpClient())
        .build().create(RickAndMortyLocationsService::class.java)
}
