package dev.alexferreira.ui.presenter.fragment

import android.os.Bundle
import android.view.MenuItem
import dev.alexferreira.R
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.data.repository.IPedidoClienteRepository
import dev.alexferreira.injection.scope.FragmentScope
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.task.LoadPedidoClienteTask
import dev.alexferreira.ui.task.generic.TaskCallback
import timber.log.Timber
import javax.inject.Inject

@FragmentScope
class HistoricoPedidoFragPresenter @Inject constructor(val pedidoRepo: IPedidoClienteRepository) :
    AbstractFragPresenter<DadosClienteContract.HistoricoPedidoContract.FragView>(),
    DadosClienteContract.HistoricoPedidoContract.FragPresenter {

    lateinit var currentCliente: Cliente
    lateinit var clienteId: String

    override fun onViewStarted(args: Bundle?) {
        super.onViewStarted(args)
        args?.let {
            clienteId = it.getString(DadosClienteFragPresenter.ARG_CLIENTE_ID)!!
        }
        LoadPedidoClienteTask(object : TaskCallback<List<PedidoCliente>> {
            override fun onEmpty() {
                view.hideProgressBar()

                view.showEmptyView()
            }

            override fun onSuccessResult(model: List<PedidoCliente>) {
                view.hideProgressBar()

                view.initListView(model)
                view.showListView()
            }
        }, pedidoRepo).execute(clienteId)
        view.setHasOptionMenu(true)
    }

    override fun selectOptionMenu(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.legenda_historico_pedidos_menu -> {
                view.showLegendaDialog()
            }
            else -> {
                Timber.e("Não foi tratado selecao de menu: ${menuItem.title} com id: ${menuItem.itemId}")
            }
        }
    }

    companion object {
        const val ARG_CLIENTE_ID = "cliente_id"
    }
}