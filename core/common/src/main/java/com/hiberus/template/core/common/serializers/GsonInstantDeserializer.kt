package com.hiberus.template.core.common.serializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.hiberus.template.core.common.entities.supportedDateFormat
import com.hiberus.template.core.common.extensions.format
import com.hiberus.template.core.common.extensions.iif
import com.hiberus.template.core.common.extensions.toInstant
import java.lang.reflect.Type
import java.text.ParseException
import java.time.Instant

// With this class we can parse some date formats received into json data, and is very simple to extend to new formats
class GsonInstantDeserializer: JsonDeserializer<Instant>, JsonSerializer<Instant> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Instant? {
        for (format in supportedDateFormat){
            try {
                val stringDate = json?.asJsonPrimitive?.asString

                return stringDate?.toInstant(format)
            } catch (_: Exception) {

            }
        }

        throw ParseException("Error parsing date", 0)
    }

    override fun serialize(
        src: Instant?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement? {
        return (src == null).iif({ null }, { JsonPrimitive(src.format("yyyy-MM-dd'T'HH:mm:ss")) })
    }
}