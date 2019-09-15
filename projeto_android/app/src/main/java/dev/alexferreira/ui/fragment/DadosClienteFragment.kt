package dev.alexferreira.ui.fragment


import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.alexferreira.R
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.presenter.fragment.DadosClienteFragPresenter
import kotlinx.android.synthetic.main.fragment_dados_cliente.*

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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_dados_cliente, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bt_verify_estado_cliente.setOnClickListener {
            presenter.selectVerifyEstadoCliente()
        }
    }

    override fun showSnackBarMsg(msg: String) {
        val snackbar = Snackbar.make(coordinatorLayout, msg, Snackbar.LENGTH_INDEFINITE)
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
                    putString(DadosClienteFragPresenter.ARG_CLIENTE_ID, clienteId)
                }
            }
    }
}
