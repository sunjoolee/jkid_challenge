package ru.yole.jkid

import ru.yole.jkid.deserialization.JKidException
import java.text.SimpleDateFormat
import java.util.*

@Target(AnnotationTarget.PROPERTY)
annotation class DateFormat(val format: String)

class DateSerializer(val format: String) : ValueSerializer<Date> {
    override fun toJsonValue(value: Date): Any = SimpleDateFormat(format).format(value)

    override fun fromJsonValue(jsonValue: Any?): Date {
        if (jsonValue !is String?) throw JKidException("Expected Date, was: $jsonValue")
        return SimpleDateFormat("dd-MM-yyyy").parse(jsonValue)
    }
}
