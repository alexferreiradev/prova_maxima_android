package dev.alexferreira.data.model

enum class StatusPedido(val description: String) {

    PROCESSADO("Processado"),
    EM_PROCESSAMENTO("Em processamento"),
    PENDENTE("Pendente");

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