package dev.alexferreira.ui.contract

import dev.alexferreira.data.model.Cliente

interface Navigator {

    fun openMainMenuView()
    fun openDadosClienteView(cliente: Cliente)

}
