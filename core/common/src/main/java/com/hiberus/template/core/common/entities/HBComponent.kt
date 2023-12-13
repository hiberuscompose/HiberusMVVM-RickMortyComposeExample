package com.hiberus.template.core.common.entities

import com.hiberus.template.core.common.entities.enums.Component
import javax.annotation.concurrent.Immutable

@Immutable
data class HBComponent(
    val title: String,
    val thumbnail: String
)

val hbComponents = getList()

private fun getList(): List<HBComponent> {
    val list = arrayListOf<HBComponent>()
    Component.values().forEach { component ->
        list.add(HBComponent(component.name, component.thumbnail))
    }
    return list
}