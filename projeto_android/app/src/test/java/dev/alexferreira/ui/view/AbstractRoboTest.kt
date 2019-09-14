package dev.alexferreira.ui.view

import android.content.Context
import android.content.Intent
import dev.alexferreira.application.RoboApp
import dev.alexferreira.ui.contract.IPresenter
import dev.alexferreira.ui.contract.IView
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
abstract class AbstractRoboTest<A : AbstractView<V, P>, V : IView, P : IPresenter<V>>(private val actClass: Class<A>) {

    private lateinit var intent: Intent
    private lateinit var context: Context

    private lateinit var presenter: P
    private lateinit var activity: A

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        activity = Robolectric.buildActivity(actClass).create().start().get()
        presenter = activity.presenter
    }
}