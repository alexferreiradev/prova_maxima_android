package dev.alexferreira.data.model

import android.arch.persistence.room.TypeConverter
import com.google.gson.annotations.SerializedName

enum class StatusCliente(val desc: String) {
    @SerializedName("Indefinido")
    INDEFINIDO("Indefinido"),
    @SerializedName("Ativo")
    ATIVO("Ativo");

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