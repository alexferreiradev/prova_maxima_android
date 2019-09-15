package dev.alexferreira.ui.fragment

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import dev.alexferreira.R
import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.ui.contract.DadosClienteContract
import org.jetbrains.anko.find
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test

class HistoricoFragmentRoboTest :
    AbstractFragmentRoboTest<HistoricoPedidoFragment, DadosClienteContract.HistoricoPedidoContract.FragView
            , DadosClienteContract.HistoricoPedidoContract.FragPresenter>(
        HistoricoPedidoFragment.newInstance("1")
    ) {

    @Test
    fun contract_setHasMenu_true() {
        contract.setHasOptionMenu(true)
        Assert.assertTrue("Não foi setado has menu", fragment.hasOptionsMenu())
    }

    @Test
    fun contract_showEmptyView_changeVisibility() {
        contract.showEmptyView()

        val textView = fragment.view!!.find<TextView>(R.id.tv_empty)
        Assert.assertEquals("Empty não esta visivel", View.VISIBLE, textView.visibility)
        val recyclerView = fragment.view!!.find<RecyclerView>(R.id.recyclerView)
        Assert.assertEquals(View.GONE, recyclerView.visibility)
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
    fun contract_initDados_createAdapter() {
        val fakeList = ArrayList<PedidoCliente>()
        fakeList.add(fakePedidoCliente)
        contract.initListView(fakeList)

        val recyclerView = fragment.view!!.find<RecyclerView>(R.id.recyclerView)
        Assert.assertNotNull(recyclerView.adapter)
    }

    @Ignore("Nao consegui simular click de menu de fragment")
    @Test
    fun selectMenu_legenda_callPresenter() {
//        val shadowOfFrag = Shadows.shadowOf(fragment)
//        shadowOfFrag.click
    }
}