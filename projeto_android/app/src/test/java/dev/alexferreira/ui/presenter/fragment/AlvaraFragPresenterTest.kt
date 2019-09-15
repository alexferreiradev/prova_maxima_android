package dev.alexferreira.ui.presenter.fragment

import dev.alexferreira.ui.contract.DadosClienteContract
import org.junit.Test
import org.mockito.Mockito

class AlvaraFragPresenterTest : AbstractFragPresenterTest<
        DadosClienteContract.AlvaraContract.FragView, DadosClienteContract.AlvaraContract.FragPresenter,
        AlvaraFragPresenter>(
    DadosClienteContract.AlvaraContract.FragView::class.java
) {

    @Test
    fun contract_onViewStarted_callView() {
        contract.onViewStarted(args)

        Mockito.verify(view).showEmptyLayout()
    }

    override fun createPresenterInstance(): AlvaraFragPresenter {
        return AlvaraFragPresenter()
    }
}