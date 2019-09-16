package dev.alexferreira.data.model

import android.arch.persistence.room.TypeConverter
import com.google.gson.annotations.SerializedName

enum class TipoPedido(val desc: String) {
    @SerializedName("PEDIDO")
    PEDIDO("PEDIDO"),
    @SerializedName("ORCAMENTO")
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