package dev.alexferreira.data.source.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import dev.alexferreira.data.model.Cliente

@Dao
interface ClienteDao {

    @Query("select * from cliente")
    fun getAll(): List<Cliente>

    @Query("select * from cliente where cliente.id == :id limit 1")
    fun getById(id: String): Cliente?

    @Insert
    fun save(cliente: Cliente): Long

}