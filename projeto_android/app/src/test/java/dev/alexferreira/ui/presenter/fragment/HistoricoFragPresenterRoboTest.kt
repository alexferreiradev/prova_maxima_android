package dev.alexferreira.ui.presenter.fragment

import com.nhaarman.mockitokotlin2.any
import dev.alexferreira.ui.contract.DadosClienteContract
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito


class HistoricoFragPresenterRoboTest : AbstractFragPresenterRoboTest<
        DadosClienteContract.HistoricoPedidoContract.FragView, DadosClienteContract.HistoricoPedidoContract.FragPresenter,
        HistoricoPedidoFragPresenter>(
    DadosClienteContract.HistoricoPedidoContract.FragView::class.java
) {
    override fun createPresenterInstance(): HistoricoPedidoFragPresenter {
        return HistoricoPedidoFragPresenter(pedidoRepo)
    }

    @Test
    fun onStart_loadCliente_initList() {
        Mockito.`when`(args.getString(any())).thenReturn("1")

        presenter.onViewStarted(args)

        Assert.assertNotNull(presenter.clienteId)
        Mockito.verify(view).hideProgressBar()
        Mockito.verify(view).initListView(any())
        Mockito.verify(view).showListView()
    }

    @Test
    fun onStart_loadCliente_showEmpty() {
        Mockito.reset(pedidoRepo)
        Mockito.`when`(pedidoRepo.getAll()).thenReturn(ArrayList())
        Mockito.`when`(args.getString(any())).thenReturn("1")
        presenter.onViewStarted(args)

        Assert.assertNotNull(presenter.clienteId)
        Mockito.verify(view).hideProgressBar()
        Mockito.verify(view).showEmptyView()
    }
}