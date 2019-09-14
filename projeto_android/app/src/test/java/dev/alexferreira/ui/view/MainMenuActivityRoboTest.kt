package dev.alexferreira.ui.view

import android.content.Context
import android.content.Intent
import dev.alexferreira.application.RoboApp
import dev.alexferreira.ui.contract.MainMenuContract
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = RoboApp::class)
class MainMenuActivityRoboTest {
    private lateinit var intent: Intent
    @Mock
    private lateinit var context: Context

    private lateinit var presenter: MainMenuContract.Presenter
    private lateinit var activity: MainMenuActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        activity = Robolectric.buildActivity(MainMenuActivity::class.java).create().start().get()
        presenter = activity.presenter
    }
}