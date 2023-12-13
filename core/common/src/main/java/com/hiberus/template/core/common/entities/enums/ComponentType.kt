package com.hiberus.template.core.common.entities.enums

enum class Component(
    override val thumbnail: String = ""
) : ComponentType {
    Button("hb_button"),
    Text("hb_text"),
    Logo("hb_logo")
}

internal interface ComponentType {
    val thumbnail: String
}