package dev.alexferreira.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.alexferreira.R


private const val ARG_CLIENTE_ID = "cliente_id"

/**
 * A simple [Fragment] subclass.
 * Use the [AlvaraFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AlvaraFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_alvara, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment AlvaraFragment.
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
