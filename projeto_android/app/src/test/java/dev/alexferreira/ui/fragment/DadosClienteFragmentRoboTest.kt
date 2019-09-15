package dev.alexferreira.ui.fragment

import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.widget.Button
import dev.alexferreira.R
import dev.alexferreira.application.RoboApp
import dev.alexferreira.ui.contract.DadosClienteContract
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
class DadosClienteFragmentRoboTest :
    AbstractFragmentRoboTest<DadosClienteFragment, DadosClienteContract.DadosClienteFragContract.FragView
            , DadosClienteContract.DadosClienteFragContract.FragPresenter>(
        DadosClienteFragment.newInstance("1")
    ) {

    @Test
    fun selecttVerifyStatus_callPresenter() {
        fragment.view!!.findViewById<Button>(R.id.bt_verify_estado_cliente).performClick()

        Mockito.verify(presenter).selectVerifyEstadoCliente()
    }

    @Test
    fun contract_showSnackbar() {
        contract.showSnackBarMsg("Teste")

        val snackBar = (fragment.view!! as CoordinatorLayout).getChildAt(1) as Snackbar.SnackbarLayout
        Assert.assertNotNull(snackBar)
    }
}