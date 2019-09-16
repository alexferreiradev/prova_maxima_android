package dev.alexferreira.data.source.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import dev.alexferreira.data.model.PedidoCliente

@Dao
interface PedidoClienteDao {

    @Query("select * from pedidocliente")
    fun getAll(): List<PedidoCliente>

    @Query("select * from pedidocliente as p where p.codigoCliente == :id")
    fun getAllByClienteId(id: String): List<PedidoCliente>

    @Insert
    fun save(model: PedidoCliente): Long

    @Insert
    fun saveAll(modelList: List<PedidoCliente>)

}