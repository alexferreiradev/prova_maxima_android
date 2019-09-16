package dev.alexferreira.ui.presenter

import android.content.Intent
import android.view.MenuItem
import dev.alexferreira.R
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.repository.IClienteRepository
import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.adapter.DadosClienteViewPagerAdapter
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.task.LoadClienteTask
import dev.alexferreira.ui.task.generic.TaskCallback
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class DadosClientePresenter @Inject constructor(val cliRepo: IClienteRepository) :
    AbstractPresenter<DadosClienteContract.View>(),
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

    override fun onPageSelected(pos: Int) {
        when (pos) {
            DadosClienteViewPagerAdapter.DADOS_CLIENTE_POS -> {
                view.setBottomNavSelectedItem(R.id.dados_cliente_menu_item)
                view.setAbTitle(R.string.dados_cliente_ab_title)
            }
            DadosClienteViewPagerAdapter.HISTORICO_PEDIDOS_POS -> {
                view.setBottomNavSelectedItem(R.id.historico_dados_cliente_menu_item)
                view.setAbTitle(R.string.pedido_cliente_ab_title)
            }
            DadosClienteViewPagerAdapter.ALVARA_POS -> {
                view.setBottomNavSelectedItem(R.id.alvara_dados_cliente_menu_item)
                view.setAbTitle(R.string.alvara_ab_title)
            }
            else -> {
                Timber.e("Pagina selecionada não tradada: $pos")
            }
        }
    }

    override fun onViewStarted(intent: Intent?) {
        super.onViewStarted(intent)
        LoadClienteTask(object : TaskCallback<Cliente> {
            override fun onEmpty() {
            }

            override fun onSuccessResult(model: Cliente) {
                view.hideProgressBar()

                view.initViewPager(model)
            }
        }, cliRepo).execute(intent!!.getStringExtra(getString(R.string.cliente_id_intent_key)))
    }
}