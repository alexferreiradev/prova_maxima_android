package dev.alexferreira.ui.contract

import dev.alexferreira.data.model.Cliente

interface NavigatableView {
    fun openMainMenuView()
    fun openDadosClienteView(cliente: Cliente)
}