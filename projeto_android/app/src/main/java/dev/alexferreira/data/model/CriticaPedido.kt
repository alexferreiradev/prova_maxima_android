package dev.alexferreira.data.model

enum class CriticaPedido(val desc: String) {
    FALHA_PARCIAL("FALHA_PARCIAL"),
    SUCESSO("SUCESSO");

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