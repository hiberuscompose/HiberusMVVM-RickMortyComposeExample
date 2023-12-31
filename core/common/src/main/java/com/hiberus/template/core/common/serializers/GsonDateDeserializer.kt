package com.hiberus.template.core.common.serializers

import com.google.gson.*
import com.hiberus.template.core.common.entities.supportedDateFormat
import com.hiberus.template.core.common.extensions.format
import com.hiberus.template.core.common.extensions.iif
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class GsonDateDeserializer: JsonDeserializer<Date>, JsonSerializer<Date> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date {
        for (format in supportedDateFormat){
            try {
                val stringDate = json?.asJsonPrimitive?.asString

                return stringDate?.let { SimpleDateFormat(format).parse(it) } as Date
            } catch (_: Exception) {

            }
        }

        throw ParseException("Error parsing date", 0)
    }

    override fun serialize(
        src: Date?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement? {
        return (src == null).iif({ null }, { JsonPrimitive(src.format("yyyy-MM-dd'T'HH:mm:ss")) })
    }
}