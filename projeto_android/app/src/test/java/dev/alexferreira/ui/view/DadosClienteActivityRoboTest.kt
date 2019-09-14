package dev.alexferreira.ui.view

import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import dev.alexferreira.R
import dev.alexferreira.ui.contract.DadosClienteContract
import org.hamcrest.Matchers
import org.jetbrains.anko.find
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito


class DadosClienteActivityRoboTest :
    AbstractRoboTest<DadosClienteActivity, DadosClienteContract.View, DadosClienteContract.Presenter>(
        DadosClienteActivity::class.java
    ) {
    @Test
    fun initFragmentView() {
        view.initViewPager()

        val viewPager = activity.find<ViewPager>(R.id.viewPager)

        Assert.assertNotNull(viewPager.adapter)
    }

    @Test
    fun selectBottomNav_dados_callPresenter() {
        val bottomNavigationView = activity.find<BottomNavigationView>(R.id.bottomNavigationView)
        val menuItem = bottomNavigationView.menu.findItem(R.id.dados_cliente_menu_item)
        menuItem.actionView.performClick()

        Mockito.verify(presenter).selectBottomNavItemMenu(menuItem)
    }

    @Test
    fun selectBottomNav_historico_callPresenter() {
        val bottomNavigationView = activity.find<BottomNavigationView>(R.id.bottomNavigationView)
        val menuItem = bottomNavigationView.menu.findItem(R.id.historico_dados_cliente_menu_item)
        menuItem.actionView.performClick()

        Mockito.verify(presenter).selectBottomNavItemMenu(menuItem)
    }

    @Test
    fun selectBottomNav_alvara_callPresenter() {
        val bottomNavigationView = activity.find<BottomNavigationView>(R.id.bottomNavigationView)
        val menuItem = bottomNavigationView.menu.findItem(R.id.alvara_dados_cliente_menu_item)
        menuItem.actionView.performClick()

        Mockito.verify(presenter).selectBottomNavItemMenu(menuItem)
    }

    @Test
    fun selectViewPagerPos() {
        val viewPagerPos = 1
        view.setViewPagerPos(viewPagerPos)

        val viewPager = activity.find<ViewPager>(R.id.viewPager)
        Assert.assertThat(viewPager.currentItem, Matchers.`is`(viewPagerPos))
    }

    //    @Before
//    override fun setUp() {
//        super.setUp()
//        startDadosList()
//    }
//
//    @Test
//    fun selectVerifyStatus_callPresenter() {
//        activity.findViewById<Button>(R.id.bt_verify_estado_cliente).performClick()
//
//        Mockito.verify(presenter).selectVerifyEstadoCliente()
//    }
//
//    @Test
//    fun selectBottom1_callPresenter() {
//        val bottomNavigationView = activity.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        bottomNavigationView.menu.findItem(R.menu.dados_cliente_bottom_menu)
//    }
//
//    @Test
//    fun initMenuAdapterList() {
//        val recyclerView = activity.findViewById<RecyclerView>(R.id.recyclerView)
//
//        Assert.assertNotNull(recyclerView.adapter)
//        Assert.assertNotNull(recyclerView.layoutManager)
//        Assert.assertThat(
//            recyclerView.layoutManager!!.javaClass.name, Matchers.`is`(LinearLayoutManager::class.java.name)
//        )
//    }
}