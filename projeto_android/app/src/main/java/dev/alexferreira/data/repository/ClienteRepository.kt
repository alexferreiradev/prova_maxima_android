package dev.alexferreira.data.repository

import dev.alexferreira.data.model.Cliente
import dev.alexferreira.injection.scope.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class ClienteRepository @Inject constructor() : IClienteRepository {

    override fun getCliente(id: String?): Cliente? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): List<Cliente> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
