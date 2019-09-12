package dev.alexferreira.data.source.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.data.source.database.converter.*

@Database(entities = [Cliente::class, PedidoCliente::class], version = 1, exportSchema = false)
@TypeConverters(
    StatusClienteConverter::class,
    StatusPedidoConverter::class,
    TipoPedidoConverter::class,
    ListConverters::class,
    CriticaPedidoConverter::class
)
abstract class AbstractDataBase : RoomDatabase(), DaoCreator