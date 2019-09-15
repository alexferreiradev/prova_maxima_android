package dev.alexferreira.ui.presenter

import dev.alexferreira.data.model.Cliente
import dev.alexferreira.ui.contract.MainMenuContract
import org.junit.Test
import org.mockito.Mockito

class MainMenuPresenterTest :
    AbstractPresenterTest<MainMenuContract.View, MainMenuContract.Presenter, MainMenuPresenter>() {

    @Test
    fun contract_selectMenuItem_callView() {
        contract.selectMenuItem()

        val cliente = Cliente()
        Mockito.verify(view).openDadosClienteView(cliente)
    }
}