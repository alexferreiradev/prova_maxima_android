package dev.alexferreira.ui.fragment

import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import dev.alexferreira.R
import dev.alexferreira.ui.contract.DadosClienteContract
import org.jetbrains.anko.find
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

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

    @Test
    fun contract_initDados_createAdapter() {
        contract.initDadosList(fakeUser)

        val recyclerView = fragment.view!!.find<RecyclerView>(R.id.recyclerView)
        Assert.assertNotNull(recyclerView.adapter)
    }

    @Test
    fun contract_showListView_changeVisibility() {
        contract.showListView()

        val recyclerView = fragment.view!!.find<RecyclerView>(R.id.recyclerView)
        Assert.assertEquals(View.VISIBLE, recyclerView.visibility)
        val emptyText = fragment.view!!.find<TextView>(R.id.tv_empty)
        Assert.assertEquals(View.GONE, emptyText.visibility)
    }

    @Test
    fun contract_showEmptyLayout_changeVisibility() {
        contract.showEmptyLayout()

        val recyclerView = fragment.view!!.find<RecyclerView>(R.id.recyclerView)
        Assert.assertEquals(View.GONE, recyclerView.visibility)
        val emptyText = fragment.view!!.find<TextView>(R.id.tv_empty)
        Assert.assertEquals(View.VISIBLE, emptyText.visibility)
    }
}