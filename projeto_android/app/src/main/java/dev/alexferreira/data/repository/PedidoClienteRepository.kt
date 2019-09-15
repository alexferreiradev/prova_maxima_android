package dev.alexferreira.data.repository

import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.injection.scope.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class PedidoClienteRepository @Inject constructor() : IPedidoClienteRepository {

    override fun getAll(): List<PedidoCliente> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
