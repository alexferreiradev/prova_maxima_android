package dev.alexferreira.ui.presenter.fragment

import android.os.Bundle
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.injection.scope.FragmentScope
import dev.alexferreira.ui.contract.DadosClienteContract
import java.text.DateFormat
import java.util.*
import javax.inject.Inject

@FragmentScope
class DadosClienteFragPresenter @Inject constructor() :
    AbstractFragPresenter<DadosClienteContract.DadosClienteFragContract.FragView>(),
    DadosClienteContract.DadosClienteFragContract.FragPresenter {

    lateinit var clientId: String
    lateinit var currentCliente: Cliente

    override fun selectVerifyEstadoCliente() {
        val today = Date()
        val date = DateFormat.getDateInstance(DateFormat.SHORT).format(today)
        val hour = DateFormat.getTimeInstance(DateFormat.SHORT).format(today)
        val msg: String = String.format("%s %s - %s", date, hour, currentCliente.status?.desc)
        view.showSnackBarMsg(msg)
    }

    override fun onViewStarted(args: Bundle?) {
        args?.let {
            clientId = it.getString(ARG_CLIENTE_ID)!!
        }
    }

    companion object {
        const val ARG_CLIENTE_ID = "cliente_id"
    }
}