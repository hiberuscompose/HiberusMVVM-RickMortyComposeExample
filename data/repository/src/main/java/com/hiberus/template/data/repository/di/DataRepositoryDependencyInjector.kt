package com.hiberus.template.data.repository.di

import com.hiberus.template.data.datasources.features.characters.RickAndMortyCharactersService
import com.hiberus.template.data.datasources.features.settings.Preferences
import com.hiberus.template.data.repository.features.characters.CharactersPagingImpl
import com.hiberus.template.data.repository.features.characters.CharactersRepositoryImpl
import com.hiberus.template.data.repository.settings.PreferencesRepositoryImpl
import com.hiberus.template.domain.repository.features.characters.CharactersPaging
import com.hiberus.template.domain.repository.features.characters.CharactersRepository
import com.hiberus.template.domain.repository.settings.PreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataRepositoryDependencyInjector {
    @Provides
    fun providesPreferencesRepository(preferences: Preferences): PreferencesRepository =
        PreferencesRepositoryImpl(preferences)

    @Provides
    fun providesCharacterRepository(
        service: RickAndMortyCharactersService
    ): CharactersRepository = CharactersRepositoryImpl(service)

    @Provides
    fun providesCharactersPaging(
        repository: CharactersRepository
    ): CharactersPaging = CharactersPagingImpl(repository)
}
