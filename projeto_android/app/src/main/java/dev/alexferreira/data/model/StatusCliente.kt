package dev.alexferreira.data.model

enum class StatusCliente(val desc: String) {
    INDEFINIDO("Indefinido");

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