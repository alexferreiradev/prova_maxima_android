package dev.alexferreira.ui.presenter.fragment

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import dev.alexferreira.data.model.StatusCliente
import dev.alexferreira.ui.contract.DadosClienteContract
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import java.util.regex.Pattern

class DadosClienteFragPresenterTest : AbstractFragPresenterTest<
        DadosClienteContract.DadosClienteFragContract.FragView, DadosClienteContract.DadosClienteFragContract.FragPresenter,
        DadosClienteFragPresenter>(
    DadosClienteContract.DadosClienteFragContract.FragView::class.java
) {

    @Test
    fun contract_selectVerify_callView() {
        presenter.currentCliente = mock()
        Mockito.`when`(presenter.currentCliente.status).thenReturn(StatusCliente.INDEFINIDO)
        Mockito.`when`(view.showSnackBarMsg(any())).thenAnswer {
            val msg = it.arguments[0] as String
            val compile = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{2} \\d{1,2}:\\d{1,2}( (PM|AM))? - Indefinido")
            val matcher = compile.matcher(msg)
            Assert.assertTrue("Não encontrado padrao em: $msg", matcher.find())
        }

        contract.selectVerifyEstadoCliente()

        Mockito.verify(view).showSnackBarMsg(any())
    }

    override fun createPresenterInstance(): DadosClienteFragPresenter {
        return DadosClienteFragPresenter(cliRepo)
    }
}