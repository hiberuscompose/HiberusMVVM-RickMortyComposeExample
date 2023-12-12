package com.hiberus.template.domain.repository.features.characters

import com.hiberus.template.core.common.entities.enums.GenderFilter
import com.hiberus.template.core.common.entities.enums.StatusFilter
import com.hiberus.template.domain.models.characters.RickAndMortyCharacter
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    suspend fun getAllCharacters(page: Int): List<RickAndMortyCharacter>

    fun getFilteredCharacters(
        page: Int,
        filterByName: String,
        filterByStatus: StatusFilter,
        filterBySpecies: String,
        filterByGender: GenderFilter
    ): Flow<List<RickAndMortyCharacter>>

    fun getCharacterById(characterId: Int): Flow<RickAndMortyCharacter>

    fun getDiscreteCharacters(characters: List<Int>): Flow<List<RickAndMortyCharacter>>
}