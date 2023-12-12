package com.hiberus.template.data.repository.features.characters

import com.hiberus.template.core.common.entities.enums.GenderFilter
import com.hiberus.template.core.common.entities.enums.StatusFilter
import com.hiberus.template.data.datasources.features.characters.RickAndMortyCharactersService
import com.hiberus.template.data.repository.features.characters.mappers.toDomain
import com.hiberus.template.domain.models.characters.RickAndMortyCharacter
import com.hiberus.template.domain.repository.features.characters.CharactersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val remote:  RickAndMortyCharactersService
): CharactersRepository {
    override suspend fun getAllCharacters(page: Int): List<RickAndMortyCharacter> {
        val remoteData = remote.getAllCharacters(page)
        if (remoteData.isSuccessful){
            return remoteData.body()?.results?.let {data ->
                data.map { rmCharacter -> rmCharacter.toDomain() }
            } ?: emptyList()
        }

        return emptyList()
    }

    override fun getFilteredCharacters(
        page: Int,
        filterByName: String,
        filterByStatus: StatusFilter,
        filterBySpecies: String,
        filterByGender: GenderFilter
    ): Flow<List<RickAndMortyCharacter>> {
        TODO("Not yet implemented")
    }

    override fun getCharacterById(characterId: Int): Flow<RickAndMortyCharacter> {
        TODO("Not yet implemented")
    }

    override fun getDiscreteCharacters(characters: List<Int>): Flow<List<RickAndMortyCharacter>> {
        TODO("Not yet implemented")
    }
}