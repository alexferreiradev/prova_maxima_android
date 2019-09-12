package dev.alexferreira.data.model

import android.arch.persistence.room.TypeConverter

enum class TipoPedido(val desc: String) {
    PEDIDO("PEDIDO"),
    ORCAMENTO("ORCAMENTO");

    companion object {
        @TypeConverter
        fun fromDesc(desc: String): TipoPedido? {
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