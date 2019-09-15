package dev.alexferreira.ui.presenter

import android.view.MenuItem
import dev.alexferreira.R
import dev.alexferreira.ui.adapter.DadosClienteViewPagerAdapter
import dev.alexferreira.ui.contract.DadosClienteContract
import timber.log.Timber
import javax.inject.Inject

class DadosClientePresenter @Inject constructor() : AbstractPresenter<DadosClienteContract.View>(),
    DadosClienteContract.Presenter {

    override fun selectBottomNavItemMenu(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.dados_cliente_menu_item -> {
                view.setViewPagerPos(DadosClienteViewPagerAdapter.DADOS_CLIENTE_POS)
                return true
            }
            R.id.historico_dados_cliente_menu_item -> {
                view.setViewPagerPos(DadosClienteViewPagerAdapter.HISTORICO_PEDIDOS_POS)
                return true
            }
            R.id.alvara_dados_cliente_menu_item -> {
                view.setViewPagerPos(DadosClienteViewPagerAdapter.ALVARA_POS)
                return true
            }
            else -> {
                Timber.e("Click de menu sendo ignorado: ${menuItem.itemId}")
                return false
            }
        }
    }
}