package dev.alexferreira.data.source.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import dev.alexferreira.data.model.ClienteContato

@Dao
interface ContatoClienteDao {
    @Query("select * from ClienteContato where clienteFK = :id")
    fun getAllByCliId(id: String): List<ClienteContato>
    
    @Insert
    fun save(contato: ClienteContato): Long
}