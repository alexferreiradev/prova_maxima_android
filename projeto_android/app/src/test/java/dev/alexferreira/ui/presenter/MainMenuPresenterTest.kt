package dev.alexferreira.ui.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import dev.alexferreira.R
import dev.alexferreira.ui.contract.MainMenuContract
import dev.alexferreira.ui.model.MainMenuModel
import org.junit.Test
import org.mockito.Mockito

class MainMenuPresenterTest :
    AbstractPresenterTest<MainMenuContract.View, MainMenuContract.Presenter, MainMenuPresenter>(
        MainMenuPresenter::class.java,
        MainMenuContract.View::class.java
    ) {

    @Test
    fun contract_selectMenuItem_callView() {
        val menuTitle = "Cliente"
        presenter.currentCliente = mock()
        Mockito.`when`(context.getString(any())).thenReturn(menuTitle)
        val menuItem = MainMenuModel(R.drawable.ic_maxima_pessoa, menuTitle)
        contract.selectMenuItem(menuItem)

        Mockito.verify(view).getNavigator()
        Mockito.verify(navigator).openDadosClienteView(any())
    }
}