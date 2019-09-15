package dev.alexferreira.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.alexferreira.R

private const val ARG_CLIENTE_ID = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoricoPedidoFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HistoricoPedidoFragment : Fragment() {
    private lateinit var clienteId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            clienteId = it.getString(ARG_CLIENTE_ID)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_historico_pedido, container, false)
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
            DadosClienteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CLIENTE_ID, clienteId)
                }
            }
    }
}
