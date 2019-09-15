package dev.alexferreira.ui.presenter

import android.view.MenuItem
import com.nhaarman.mockitokotlin2.mock
import dev.alexferreira.R
import dev.alexferreira.ui.adapter.DadosClienteViewPagerAdapter
import dev.alexferreira.ui.contract.DadosClienteContract
import org.junit.Test
import org.mockito.Mockito

class DadosClientePresenterTest :
    AbstractPresenterTest<DadosClienteContract.View, DadosClienteContract.Presenter, DadosClientePresenter>(
        DadosClientePresenter::class.java,
        DadosClienteContract.View::class.java
    ) {

    @Test
    fun contract_selectBottomNav_callView() {
        val item = mock<MenuItem>()
        Mockito.`when`(item.itemId).thenReturn(R.id.dados_cliente_menu_item)
        contract.selectBottomNavItemMenu(item)

        Mockito.verify(view).setViewPagerPos(DadosClienteViewPagerAdapter.DADOS_CLIENTE_POS)
    }
}