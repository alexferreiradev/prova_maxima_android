package dev.alexferreira.helper

import java.text.DateFormat
import java.util.*

object DateHelper {

    fun formatTimestamp(timestamp: Long?): String? {
        if (timestamp == null) {
            return null
        }
        val dateInstance = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.getDefault())
        return dateInstance.format(Date(timestamp))
    }
}