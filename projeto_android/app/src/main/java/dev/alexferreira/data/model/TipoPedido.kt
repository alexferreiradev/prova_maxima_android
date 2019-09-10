package dev.alexferreira.data.model

enum class TipoPedido(val desc: String) {
    PEDIDO("PEDIDO"),
    ORCAMENTO("ORCAMENTO");

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