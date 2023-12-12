package com.hiberus.template.domain.repository.features.characters

import androidx.paging.PagingSource
import com.hiberus.template.domain.models.characters.RickAndMortyCharacter

abstract class CharactersPaging: PagingSource<Int, RickAndMortyCharacter>()