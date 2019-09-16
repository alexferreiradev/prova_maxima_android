package dev.alexferreira.data.model

import com.google.gson.annotations.SerializedName

enum class StatusPedido(val description: String) {

    @SerializedName("Processado")
    PROCESSADO("Processado"),
    @SerializedName("Em processamento")
    EM_PROCESSAMENTO("Em processamento"),
    @SerializedName("Pendente")
    PENDENTE("Pendente");

    companion object {
        fun fromDescription(description: String): StatusPedido? {
            val values = values()
            for (value in values) {
                if (value.description == description) {
                    return value
                }
            }

            return null
        }
    }
}