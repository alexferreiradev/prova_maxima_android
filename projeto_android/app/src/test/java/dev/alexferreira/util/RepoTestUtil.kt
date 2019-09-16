package dev.alexferreira.util

import com.nhaarman.mockitokotlin2.any
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.data.repository.IClienteRepository
import dev.alexferreira.data.repository.IPedidoClienteRepository
import org.mockito.Mockito

object RepoTestUtil {

    fun initCliMockRepo(
        cliRepo: IClienteRepository,
        fakeCliente: Cliente
    ) {
        Mockito.`when`(cliRepo.getCliente(any())).thenReturn(fakeCliente)
    }

    fun initPedidoMockRepo(pedidoRepo: IPedidoClienteRepository, fakePedido: PedidoCliente) {
        val modelList = ArrayList<PedidoCliente>()
        modelList.add(fakePedido)
        Mockito.`when`(pedidoRepo.getAll()).thenReturn(modelList)
    }

}
