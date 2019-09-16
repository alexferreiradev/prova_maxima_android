package dev.alexferreira.helper

import timber.log.Timber
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    fun formatTimestamp(timestamp: Long?): String? {
        if (timestamp == null) {
            return null
        }
        val dateInstance = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.getDefault())
        return dateInstance.format(Date(timestamp))
    }

    fun parseString(pattern: String, src: String?): Date? {
        if (src == null) {
            return null
        }

        try {
            return SimpleDateFormat(pattern, Locale.getDefault()).parse(src)
        } catch (e: Exception) {
            Timber.e("Erro ao fazer parse data: $src")
            return null
        }
    }
}