package dev.alexferreira.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.alexferreira.R
import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.helper.ViewHelper
import dev.alexferreira.ui.adapter.PedidoClienteListAdapter
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.presenter.fragment.HistoricoPedidoFragPresenter
import kotlinx.android.synthetic.main.fragment_alvara.recyclerView
import kotlinx.android.synthetic.main.fragment_historico_pedido.*

/**
 * A simple [Fragment] subclass.
 * Use the [HistoricoPedidoFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HistoricoPedidoFragment :
    AbstractFragment<DadosClienteContract.HistoricoPedidoContract.FragView, DadosClienteContract.HistoricoPedidoContract.FragPresenter>(),
    DadosClienteContract.HistoricoPedidoContract.FragView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_historico_pedido, container, false)
    }

    override fun setHasOptionMenu(hasMenu: Boolean) {
        setHasOptionsMenu(hasMenu)
    }

    override fun showLegendaDialog() {
        val builder = AlertDialog.Builder(requireContext()).setView(R.layout.dialog_legenda_pedido)
        builder.create().show()
    }

    override fun showEmptyView() {
        ViewHelper.showFirstHideSecond(tv_empty, recyclerView)
    }

    override fun showListView() {
        ViewHelper.showFirstHideSecond(recyclerView, tv_empty)
    }

    override fun initListView(modelList: List<PedidoCliente>) {
        recyclerView.adapter = PedidoClienteListAdapter(modelList, requireContext())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment HistoricoPedidoFragment.
         */
        @JvmStatic
        fun newInstance(clienteId: String) =
            HistoricoPedidoFragment().apply {
                arguments = Bundle().apply {
                    putString(HistoricoPedidoFragPresenter.ARG_CLIENTE_ID, clienteId)
                }
            }
    }
}
