package dev.alexferreira.data.source.database

interface DaoCreator {
    fun createClienteDao(): ClienteDao
    fun createContatoClienteDao(): ContatoClienteDao
    fun createPedidoClienteDao(): PedidoClienteDao
}