package dev.alexferreira.ui.presenter

import android.content.Context
import android.content.Intent
import dev.alexferreira.ui.contract.IPresenter
import dev.alexferreira.ui.contract.IView
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

abstract class AbstractPresenterTest<V : IView, P : IPresenter<V>, C : AbstractPresenter<V>> {

    @InjectMocks
    lateinit var presenter: C

    @Mock
    lateinit var view: V
    lateinit var contract: P

    @Mock
    lateinit var context: Context
    @Mock
    lateinit var intent: Intent

    @Suppress("UNCHECKED_CAST")
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        contract = presenter as P
        contract.onViewCreated(view, context, intent)
    }

    @Test
    fun viewCreated() {
        contract.onViewCreated(view, context, intent)
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