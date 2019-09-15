@file:Suppress("DEPRECATION")

// Não posso alterar, nao uso o androidX

package dev.alexferreira.ui.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import dev.alexferreira.application.RoboApp
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.ui.contract.IFragmentPresenter
import dev.alexferreira.ui.contract.IFragmentView
import dev.alexferreira.ui.view.DadosClienteActivity
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
abstract class AbstractFragmentRoboTest<F : AbstractFragment<V, P>, V : IFragmentView, P : IFragmentPresenter<V>>(
    var fragment: F
) {

    protected lateinit var contract: V
    protected lateinit var presenter: P
    protected lateinit var context: Context
    protected var args: Bundle? = null

    @Mock
    protected lateinit var fakeUser: Cliente

    // Pois não estou utilizando o android x
    @Suppress("UNCHECKED_CAST", "DEPRECATION")
    @Before
    open fun setUp() {
        MockitoAnnotations.initMocks(this)
        val fragClass = DadosClienteActivity::class.java
        SupportFragmentTestUtil.startFragment(fragment, fragClass)
        context = RuntimeEnvironment.systemContext
        presenter = fragment.presenter
        contract = fragment as V
        args = fragment.arguments
    }

    @Test
    fun contract_create_callPresenter() {
        Mockito.verify(presenter).onViewCreated(contract, fragment.activity!!, args)
    }

    @Test
    fun contract_start_callPresenter() {
        Mockito.verify(presenter).onViewStarted(args)
    }

    @Ignore("Não consegui simular o pause")
    @Test
    fun contract_pause_callPresenter() {
        Mockito.verify(presenter).onViewPaused()
    }

    @Ignore("Não consegui simular o pause e destroy")
    @Test
    fun contract_destroy_callPresenter() {
        Mockito.verify(presenter).onViewDestroyed()
    }

    protected fun initRecyclerViewLenght(recyclerView: RecyclerView) {
        recyclerView.measure(0, 0)
        recyclerView.layout(0, 0, 100, 10000)
    }
}