package dev.alexferreira.data.repository

import dev.alexferreira.data.model.PedidoCliente

interface IPedidoClienteRepository {

    fun getAll(): List<PedidoCliente>
}