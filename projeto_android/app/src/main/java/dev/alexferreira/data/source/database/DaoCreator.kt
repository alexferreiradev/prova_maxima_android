package dev.alexferreira.data.source.database

interface DaoCreator {
    fun createClienteDao(): ClienteDao
}