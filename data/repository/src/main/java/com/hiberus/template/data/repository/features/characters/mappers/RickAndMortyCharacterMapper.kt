package com.hiberus.template.data.repository.features.characters.mappers

import com.hiberus.template.data.models.features.characters.remote.RemoteRickAndMortyCharacter
import com.hiberus.template.data.repository.features.common.toDomain
import com.hiberus.template.domain.models.characters.RickAndMortyCharacter

fun RemoteRickAndMortyCharacter.toDomain(): RickAndMortyCharacter = RickAndMortyCharacter(
    id = this.id,
    name = this.name,
    status = this.status,
    species = this.species,
    type = this.type,
    gender = this.gender,
    origin = this.origin.toDomain(),
    location = this.location.toDomain(),
    image = this.image,
    episode = this.episode,
    url = this.url,
    created = this.created,
)