package com.hiberus.template.domain.usecases.features.characters

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.hiberus.template.domain.repository.features.characters.CharactersPaging
import javax.inject.Inject

class GetPaginatedCharactersUseCase @Inject constructor(
    private val pagingService: CharactersPaging
) {
    operator fun invoke(limit: Int) = Pager(
        // aquí el tamaño de página se comporta de forma curiosa,
        // la primera petición (es así) multiplica el pagesize * 3
        config = PagingConfig(
            pageSize = limit,
            prefetchDistance = limit / 2 // aquí recolectamos a la mitad, así va más "fluido"
        ),
        pagingSourceFactory = {
            pagingService
        }
    ).flow // Si nos fijamos creamos un flow directamente desde el caso de uso.
}