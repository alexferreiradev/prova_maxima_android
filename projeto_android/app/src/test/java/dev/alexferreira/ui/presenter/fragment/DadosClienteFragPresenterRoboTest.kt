package dev.alexferreira.ui.presenter.fragment

import com.nhaarman.mockitokotlin2.any
import dev.alexferreira.ui.contract.DadosClienteContract
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito


class DadosClienteFragPresenterRoboTest : AbstractFragPresenterRoboTest<
        DadosClienteContract.DadosClienteFragContract.FragView, DadosClienteContract.DadosClienteFragContract.FragPresenter,
        DadosClienteFragPresenter>(
    DadosClienteContract.DadosClienteFragContract.FragView::class.java
) {
    override fun createPresenterInstance(): DadosClienteFragPresenter {
        return DadosClienteFragPresenter(cliRepo)
    }

    @Test
    fun onStart_loadCliente_initList() {
        Mockito.`when`(args.getString(any())).thenReturn("1")
        presenter.onViewStarted(args)

        Assert.assertNotNull(presenter.currentCliente)
        Assert.assertNotNull(presenter.clientId)
        Mockito.verify(view).hideProgressBar()
        Mockito.verify(view).initDadosList(fakeCliente)
        Mockito.verify(view).showListView()
    }

    @Test
    fun onStart_loadCliente_showEmpty() {
        Mockito.reset(cliRepo)
        Mockito.`when`(cliRepo.getCliente(any())).thenReturn(null)
        Mockito.`when`(args.getString(any())).thenReturn("1")
        presenter.onViewStarted(args)

        Assert.assertNotNull(presenter.clientId)
        Mockito.verify(view).hideProgressBar()
        Mockito.verify(view).showEmptyLayout()
    }
}