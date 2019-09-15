package dev.alexferreira.util

import com.nhaarman.mockitokotlin2.any
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.repository.IClienteRepository
import org.mockito.Mockito

object RepoTestUtil {

    fun initCliMockRepo(
        cliRepo: IClienteRepository,
        fakeCliente: Cliente
    ) {
        Mockito.`when`(cliRepo.getCliente(any())).thenReturn(fakeCliente)
    }

}
