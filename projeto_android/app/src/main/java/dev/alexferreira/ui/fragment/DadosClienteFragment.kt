package dev.alexferreira.ui.fragment

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.alexferreira.R
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.helper.ViewHelper
import dev.alexferreira.ui.adapter.ContatosClienteAdapter
import dev.alexferreira.ui.adapter.DadosClienteAdapter
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.presenter.fragment.DadosClienteFragPresenter
import kotlinx.android.synthetic.main.fragment_dados_cliente.*
import kotlinx.android.synthetic.main.item_cliente_header.*
import kotlinx.android.synthetic.main.item_contatos_cliente.*

/**
 * A simple [Fragment] subclass.
 * Use the [DadosClienteFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DadosClienteFragment : AbstractFragment<DadosClienteContract.DadosClienteFragContract.FragView,
        DadosClienteContract.DadosClienteFragContract.FragPresenter>(),
        DadosClienteContract.DadosClienteFragContract.FragView {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super
                .onCreateView(
                        inflater,
                        container,
                        savedInstanceState
                )
        return inflater
                .inflate(
                        R.layout.fragment_dados_cliente,
                        container,
                        false
                )
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bt_verify_estado_cliente.setOnClickListener {
            presenter.selectVerifyEstadoCliente()
        }
    }
    
    override fun showEmptyLayout() {
        ViewHelper
                .showFirstHideOthers(
                        tv_empty,
                        included_item_contatos,
                        included_item_dados
                )
    }
    
    override fun showListView() {
        ViewHelper
                .showFirstHideSecond(
                        included_item_contatos,
                        tv_empty
                )
        ViewHelper
                .showFirstHideSecond(
                        included_item_dados,
                        tv_empty
                )
    }
    
    override fun initDadosList(model: Cliente) {
        tv_nome.text = model.nomeFantasia
        tv_razao_social.text = model.razaoSocial
        val modelList = createDadosListFromCliente(model)
        rv_dados_cliente.adapter = DadosClienteAdapter(
                requireContext(),
                modelList
        )
        rv_dados_cliente.layoutManager = LinearLayoutManager(requireContext())
        val contatoList = model.contatoList.toMutableList()
        if (contatoList.isEmpty()) {
            ViewHelper
                    .showFirstHideSecond(
                            tv_empty_contato,
                            rv_contatos_cliente
                    )
        } else {
            rv_contatos_cliente.adapter = ContatosClienteAdapter(
                    requireContext(),
                    contatoList
            )
            rv_contatos_cliente.layoutManager = LinearLayoutManager(requireContext())
            ViewHelper
                    .showFirstHideSecond(
                            rv_contatos_cliente,
                            tv_empty_contato
                    )
        }
    }
    
    private fun createDadosListFromCliente(model: Cliente): MutableList<DadosClienteAdapter.Model> {
        return ArrayList<DadosClienteAdapter.Model>().apply {
            add(
                    DadosClienteAdapter.Model(
                            getString(R.string.cliente_cpf_label),
                            model.cnpj
                    )
            )
            add(
                    DadosClienteAdapter.Model(
                            getString(R.string.cliente_ramo_label),
                            model.ramoAtividade
                    )
            )
            add(
                    DadosClienteAdapter.Model(
                            getString(R.string.cliente_end_label),
                            model.endereco
                    )
            )
        }
    }
    
    override fun showSnackBarMsg(msg: String) {
        val snackbar = Snackbar
                .make(
                        coordinatorLayout,
                        msg,
                        Snackbar.LENGTH_INDEFINITE
                )
        snackbar.setAction(R.string.close_snack_action) { snackbar.dismiss() }
        snackbar.show()
    }
    
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param clienteId Parameter 1.
         * @return A new instance of fragment DadosClienteFragment.
         */
        @JvmStatic
        fun newInstance(clienteId: String) =
                DadosClienteFragment().apply {
                    arguments = Bundle().apply {
                        putString(
                                DadosClienteFragPresenter.ARG_CLIENTE_ID,
                                clienteId
                        )
                    }
                }
    }
}
