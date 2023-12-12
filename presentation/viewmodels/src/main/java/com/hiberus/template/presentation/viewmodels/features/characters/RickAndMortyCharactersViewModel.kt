package com.hiberus.template.presentation.viewmodels.features.characters

import androidx.lifecycle.ViewModel
import com.hiberus.template.domain.usecases.features.characters.GetPaginatedCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RickAndMortyCharactersViewModel @Inject constructor(
    private val charactersPagingUseCase: GetPaginatedCharactersUseCase
): ViewModel() {
    val paginatedCharacters = charactersPagingUseCase(PAGING_SIZE)


    companion object {
        private const val PAGING_SIZE = 20
    }
}