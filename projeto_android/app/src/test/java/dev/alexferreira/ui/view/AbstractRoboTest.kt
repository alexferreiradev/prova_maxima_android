package dev.alexferreira.ui.view

import android.content.Context
import android.content.Intent
import dev.alexferreira.application.RoboApp
import dev.alexferreira.ui.contract.IPresenter
import dev.alexferreira.ui.contract.IView
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
abstract class AbstractRoboTest<A : AbstractView<V, P>, V : IView, P : IPresenter<V>>(private val actClass: Class<A>) {

    protected lateinit var intent: Intent
    protected lateinit var context: Context

    protected lateinit var presenter: P
    protected lateinit var activity: A
    protected lateinit var view: V

    @Suppress("UNCHECKED_CAST")
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        activity = Robolectric.buildActivity(actClass).create().start().get()
        presenter = activity.presenter
        context = RuntimeEnvironment.systemContext
        view = activity as V
    }

    @Test
    fun whenCreate_callPresenter() {
        Mockito.verify(presenter).onViewCreated(view, activity.applicationContext, activity.intent)
    }

    @Ignore("Não consegui fazer mock de destroy e pause")
    @Test
    fun onViewDestroyed_callPresenter() {
        Mockito.verify(presenter).onViewDestroyed()
    }

    @Ignore("Não consegui fazer mock de destroy e pause")
    @Test
    fun onViewPaused_callPresenter() {
        activity.finish()
        Mockito.verify(presenter).onViewPaused()
    }

    @Test
    fun onViewStarted_callPresenter() {
        Mockito.verify(presenter).onViewStarted(activity.intent)
    }
}