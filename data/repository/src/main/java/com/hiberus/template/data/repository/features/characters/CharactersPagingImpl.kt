package com.hiberus.template.data.repository.features.characters

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hiberus.template.domain.models.characters.RickAndMortyCharacter
import com.hiberus.template.domain.repository.features.characters.CharactersPaging
import com.hiberus.template.domain.repository.features.characters.CharactersRepository
import timber.log.Timber
import javax.inject.Inject

open class CharactersPagingImpl @Inject constructor(
    private val repository: CharactersRepository
): CharactersPaging() {
    // Este método es as is, no se toca salvo lo estrictamente necesario
    // (obtención de la clave de páginación) :D
    override fun getRefreshKey(state: PagingState<Int, RickAndMortyCharacter>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    // Aquí sí hay que tocar un poquito...
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMortyCharacter> =
        try {
            val page = params.key ?: 1
            val limit = params.loadSize
            Timber.tag("Paging").i("Page: $page")
            // Puede ser un flow, o una suspend que se traiga cosas de cualquier sitio,
            // es un repositorio, por tanto...
            val response = repository.getAllCharacters(
                page = page,
            )

            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
}