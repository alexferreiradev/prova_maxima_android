package dev.alexferreira.data.model

import android.arch.persistence.room.TypeConverter

enum class CriticaPedido(val desc: String) {
    FALHA_PARCIAL("FALHA_PARCIAL"),
    SUCESSO("SUCESSO");

    companion object {
        @TypeConverter
        fun fromDesc(desc: String): CriticaPedido? {
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