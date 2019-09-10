package dev.alexferreira.data.source.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.model.PedidoCliente

@Database(entities = [Cliente::class, PedidoCliente::class], version = 1, exportSchema = false)
abstract class AbstractDataBase : RoomDatabase(), DaoCreator