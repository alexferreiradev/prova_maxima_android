package dev.alexferreira.ui.presenter.fragment

import android.content.Context
import android.os.Bundle
import dev.alexferreira.ui.contract.IFragmentPresenter
import dev.alexferreira.ui.contract.IFragmentView
import dev.alexferreira.ui.contract.Navigator
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

abstract class AbstractFragPresenterTest<V : IFragmentView, P : IFragmentPresenter<V>, C : AbstractFragPresenter<V>>(
    concreteClass: Class<C>,
    private val viewClass: Class<V>
) {

    @InjectMocks
    var presenter: C = concreteClass.newInstance()
    lateinit var view: V
    lateinit var contract: P

    @Mock
    lateinit var context: Context
    @Mock
    lateinit var args: Bundle
    @Mock
    lateinit var navigator: Navigator

    @Suppress("UNCHECKED_CAST")
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        view = Mockito.mock(viewClass)
        contract = presenter as P
        initMockView()
        contract.onViewCreated(view, context, args)
    }

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