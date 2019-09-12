package dev.alexferreira.ui.presenter

import android.content.Context
import android.content.Intent
import dev.alexferreira.ui.contract.SplashContract
import org.junit.Before
import org.junit.Test

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SplashPresenterTest {

    @InjectMocks
    lateinit var presenter: SplashPresenter

    @Mock
    lateinit var view: SplashContract.View
    @Mock
    lateinit var context: Context
    lateinit var intent: Intent

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter.onViewCreated(view, context, null)
    }

    @Test
    internal fun whenStarted_callNav() {
        presenter.onViewStarted(null)

        Mockito.verify(view).openMainMenuView()
    }
}