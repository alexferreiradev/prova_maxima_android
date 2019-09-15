package dev.alexferreira.ui.presenter.fragment

import android.content.Context
import android.os.Bundle
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.data.repository.IClienteRepository
import dev.alexferreira.data.repository.IPedidoClienteRepository
import dev.alexferreira.ui.contract.IFragmentPresenter
import dev.alexferreira.ui.contract.IFragmentView
import dev.alexferreira.ui.contract.Navigator
import dev.alexferreira.util.RepoTestUtil
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

abstract class AbstractFragPresenterTest<V : IFragmentView, P : IFragmentPresenter<V>, C : AbstractFragPresenter<V>>(
    private val viewClass: Class<V>
) {

    lateinit var presenter: C
    lateinit var view: V
    lateinit var contract: P

    @Mock
    lateinit var context: Context
    @Mock
    lateinit var args: Bundle
    @Mock
    lateinit var navigator: Navigator
    @Mock
    lateinit var cliRepo: IClienteRepository
    @Mock
    lateinit var pedidoRepo: IPedidoClienteRepository
    @Mock
    lateinit var fakeCliente: Cliente
    @Mock
    lateinit var fakePedidoCliente: PedidoCliente

    @Suppress("UNCHECKED_CAST")
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        view = Mockito.mock(viewClass)
        presenter = createPresenterInstance()
        contract = presenter as P
        initMockView()
        RepoTestUtil.initCliMockRepo(cliRepo, fakeCliente)
        RepoTestUtil.initPedidoMockRepo(pedidoRepo, fakePedidoCliente)
        contract.onViewCreated(view, context, args)
    }

    abstract fun createPresenterInstance(): C

    private fun initMockView() {
        Mockito.`when`(view.getNavigator()).thenReturn(navigator)
    }

    @Test
    fun viewCreated() {
        contract.onViewCreated(view, context, args)
    }

    @Test
    fun viewPaused() {
        contract.onViewPaused()
    }

    @Test
    fun viewDestroyed() {
        contract.onViewDestroyed()
    }
}