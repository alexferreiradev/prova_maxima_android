package dev.alexferreira.ui.view

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import dev.alexferreira.R
import dev.alexferreira.application.RoboApp
import dev.alexferreira.ui.contract.SplashContract
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
class SplashActivityRoboTest {
    private lateinit var intent: Intent
    @Mock
    private lateinit var context: Context

    private lateinit var presenter: SplashContract.Presenter
    private lateinit var activity: SplashActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        activity = Robolectric.buildActivity(SplashActivity::class.java).create().start().get()
        presenter = activity.presenter
    }

    @Test
    fun whenCreate_callPresenter() {
        Mockito.verify(presenter).onViewCreated(activity, activity.applicationContext, activity.intent)
    }

    @Test
    fun whenStart_showAppBackground() {
        val image = activity.findViewById<ImageView>(R.id.iv_background)

        assertNotNull(image)
    }
}