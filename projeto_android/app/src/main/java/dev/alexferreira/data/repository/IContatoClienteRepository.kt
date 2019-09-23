package dev.alexferreira.data.repository

import dev.alexferreira.data.model.ClienteContato

interface IContatoClienteRepository {
    fun getAllByClienteId(id: Long): List<ClienteContato>
}