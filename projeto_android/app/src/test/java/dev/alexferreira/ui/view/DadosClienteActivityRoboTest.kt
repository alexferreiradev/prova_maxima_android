package dev.alexferreira.ui.view

import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import dev.alexferreira.R
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.ui.contract.DadosClienteContract
import org.hamcrest.Matchers
import org.jetbrains.anko.find
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.robolectric.Shadows


class DadosClienteActivityRoboTest :
    AbstractRoboTest<DadosClienteActivity, DadosClienteContract.View, DadosClienteContract.Presenter>(
        DadosClienteActivity::class.java
    ) {
    @Test
    fun initFragmentView() {
        val cli = mock<Cliente>()
        Mockito.`when`(cli.id).thenReturn(1L)
        view.initViewPager(cli)

        val viewPager = activity.find<ViewPager>(R.id.viewPager)

        Assert.assertNotNull(viewPager.adapter)
    }

    @Test
    fun selectBottomNav_dados_callPresenter() {
        Mockito.`when`(presenter.selectBottomNavItemMenu(any())).thenAnswer {
            val menuItem = it.arguments[0] as MenuItem
            Assert.assertEquals(R.id.dados_cliente_menu_item, menuItem.itemId)
            true
        }
        Shadows.shadowOf(activity).clickMenuItem(R.id.dados_cliente_menu_item)

        Mockito.verify(presenter).selectBottomNavItemMenu(any())
    }

    @Test
    fun selectBottomNav_historico_callPresenter() {
        Mockito.`when`(presenter.selectBottomNavItemMenu(any())).thenAnswer {
            val menuItem = it.arguments[0] as MenuItem
            Assert.assertEquals(R.id.historico_dados_cliente_menu_item, menuItem.itemId)
            true
        }
        Shadows.shadowOf(activity).clickMenuItem(R.id.historico_dados_cliente_menu_item)

        Mockito.verify(presenter).selectBottomNavItemMenu(any())
    }

    @Test
    fun selectBottomNav_alvara_callPresenter() {
        Mockito.`when`(presenter.selectBottomNavItemMenu(any())).thenAnswer {
            val menuItem = it.arguments[0] as MenuItem
            Assert.assertEquals(R.id.alvara_dados_cliente_menu_item, menuItem.itemId)
            true
        }
        Shadows.shadowOf(activity).clickMenuItem(R.id.alvara_dados_cliente_menu_item)

        Mockito.verify(presenter).selectBottomNavItemMenu(any())
    }

    @Test
    fun selectViewPagerPos() {
        val viewPagerPos = 1

        val viewPager = activity.find<ViewPager>(R.id.viewPager)
        view.setViewPagerPos(viewPagerPos)

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