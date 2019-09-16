package dev.alexferreira.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.alexferreira.R
import dev.alexferreira.helper.ViewHelper
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.presenter.fragment.AlvaraFragPresenter
import kotlinx.android.synthetic.main.fragment_alvara.*


/**
 * A simple [Fragment] subclass.
 * Use the [AlvaraFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AlvaraFragment :
    AbstractFragment<DadosClienteContract.AlvaraContract.FragView, DadosClienteContract.AlvaraContract.FragPresenter>(),
    DadosClienteContract.AlvaraContract.FragView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_alvara, container, false)
    }

    override fun showEmptyLayout() {
        ViewHelper.showFirstHideSecond(empty_layout, recyclerView)
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
            AlvaraFragment().apply {
                arguments = Bundle().apply {
                    putString(AlvaraFragPresenter.ARG_CLIENTE_ID, clienteId)
                }
            }
    }
}
