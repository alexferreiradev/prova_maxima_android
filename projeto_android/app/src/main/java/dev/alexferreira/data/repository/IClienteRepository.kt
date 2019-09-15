package dev.alexferreira.data.repository

import dev.alexferreira.data.model.Cliente

interface IClienteRepository {

    fun getAll(): List<Cliente>
    fun getCliente(id: String?): Cliente?
}