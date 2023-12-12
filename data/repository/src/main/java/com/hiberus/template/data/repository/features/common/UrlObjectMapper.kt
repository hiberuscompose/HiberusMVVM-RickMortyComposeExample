package com.hiberus.template.data.repository.features.common

import com.hiberus.template.data.models.features.common.remote.RemoteUrlObject
import com.hiberus.template.domain.models.common.UrlObject

fun RemoteUrlObject.toDomain(): UrlObject = UrlObject(
    name = this.name,
    url = this.url
)