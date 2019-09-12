package dev.alexferreira.data.model

import android.arch.persistence.room.TypeConverter

enum class StatusCliente(val desc: String) {
    INDEFINIDO("Indefinido");

    companion object {
        @TypeConverter
        fun fromDesc(desc: String): StatusCliente? {
            val values = values()
            for (value in values) {
                if (value.desc == desc) {
                    return value
                }
            }

            return null
        }
    }
}