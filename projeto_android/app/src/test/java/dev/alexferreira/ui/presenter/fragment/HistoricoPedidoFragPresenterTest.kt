package dev.alexferreira.ui.presenter.fragment

import android.view.MenuItem
import com.nhaarman.mockitokotlin2.mock
import dev.alexferreira.R
import dev.alexferreira.ui.contract.DadosClienteContract
import org.junit.Test
import org.mockito.Mockito

class HistoricoPedidoFragPresenterTest : AbstractFragPresenterTest<
        DadosClienteContract.HistoricoPedidoContract.FragView, DadosClienteContract.HistoricoPedidoContract.FragPresenter,
        HistoricoPedidoFragPresenter>(
    DadosClienteContract.HistoricoPedidoContract.FragView::class.java
) {

    @Test
    fun contract_selectOptionMenu_legenda_callView() {
        val menuItem = mock<MenuItem>()
        Mockito.`when`(menuItem.itemId).thenReturn(R.id.legenda_historico_pedidos_menu)
        contract.selectOptionMenu(menuItem)

        Mockito.verify(view).showLegendaDialog()
    }

    override fun createPresenterInstance(): HistoricoPedidoFragPresenter {
        return HistoricoPedidoFragPresenter(pedidoRepo)
    }
}