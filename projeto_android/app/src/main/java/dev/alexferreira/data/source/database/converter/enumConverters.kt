package dev.alexferreira.data.source.database.converter

import android.arch.persistence.room.TypeConverter
import dev.alexferreira.data.model.CriticaPedido
import dev.alexferreira.data.model.StatusCliente
import dev.alexferreira.data.model.StatusPedido
import dev.alexferreira.data.model.TipoPedido

object StatusClienteConverter {
    @TypeConverter
    @JvmStatic
    fun toEnum(desc: String?): StatusCliente? {
        if (desc == null) {
            return null
        }

        return StatusCliente.fromDesc(desc)
    }

    @TypeConverter
    @JvmStatic
    fun fromEnum(statusCliente: StatusCliente?): String {
        return statusCliente?.desc ?: ""
    }
}

object StatusPedidoConverter {
    @TypeConverter
    @JvmStatic
    fun toEnum(desc: String?): StatusPedido? {
        if (desc == null) {
            return null
        }
        return StatusPedido.fromDescription(desc)
    }

    @TypeConverter
    @JvmStatic
    fun fromEnum(value: StatusPedido?): String {
        return value?.description ?: ""
    }
}

object TipoPedidoConverter {
    @TypeConverter
    @JvmStatic
    fun toEnum(desc: String?): TipoPedido? {
        if (desc == null) {
            return null
        }

        return TipoPedido.fromDesc(desc)
    }

    @TypeConverter
    @JvmStatic
    fun fromEnum(value: TipoPedido?): String {
        return value?.desc ?: ""
    }
}

object CriticaPedidoConverter {
    @TypeConverter
    @JvmStatic
    fun toEnum(desc: String?): CriticaPedido? {
        return CriticaPedido.fromDesc(desc)
    }

    @TypeConverter
    @JvmStatic
    fun fromEnum(value: CriticaPedido?): String {
        if (value == null) {
            return ""
        }

        return value.desc
    }
}