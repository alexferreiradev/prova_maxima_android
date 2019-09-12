package dev.alexferreira.data.source.database.converter

import android.arch.persistence.room.TypeConverter
import dev.alexferreira.data.model.CriticaPedido
import dev.alexferreira.data.model.StatusCliente
import dev.alexferreira.data.model.StatusPedido
import dev.alexferreira.data.model.TipoPedido

object StatusClienteConverter {
    @TypeConverter
    @JvmStatic
    fun toEnum(desc: String): StatusCliente? {
        return StatusCliente.fromDesc(desc)
    }

    @TypeConverter
    @JvmStatic
    fun fromEnum(statusCliente: StatusCliente): String {
        return statusCliente.desc
    }
}

object StatusPedidoConverter {
    @TypeConverter
    @JvmStatic
    fun toEnum(desc: String): StatusPedido? {
        return StatusPedido.fromDescription(desc)
    }

    @TypeConverter
    @JvmStatic
    fun fromEnum(value: StatusPedido): String {
        return value.description
    }
}

object TipoPedidoConverter {
    @TypeConverter
    @JvmStatic
    fun toEnum(desc: String): TipoPedido? {
        return TipoPedido.fromDesc(desc)
    }

    @TypeConverter
    @JvmStatic
    fun fromEnum(value: TipoPedido): String {
        return value.desc
    }
}

object CriticaPedidoConverter {
    @TypeConverter
    @JvmStatic
    fun toEnum(desc: String): CriticaPedido? {
        return CriticaPedido.fromDesc(desc)
    }

    @TypeConverter
    @JvmStatic
    fun fromEnum(value: CriticaPedido): String {
        return value.desc
    }
}