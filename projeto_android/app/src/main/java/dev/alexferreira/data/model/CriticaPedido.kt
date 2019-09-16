package dev.alexferreira.data.model

import android.arch.persistence.room.TypeConverter
import com.google.gson.annotations.SerializedName

enum class CriticaPedido(val desc: String) {
    @SerializedName("FALHA_PARCIAL")
    FALHA_PARCIAL("FALHA_PARCIAL"),
    @SerializedName("SUCESSO")
    SUCESSO("SUCESSO");

    companion object {
        @TypeConverter
        fun fromDesc(desc: String?): CriticaPedido? {
            if (desc == null) {
                return null
            }

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