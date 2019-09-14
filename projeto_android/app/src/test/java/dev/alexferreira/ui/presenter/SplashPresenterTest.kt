package dev.alexferreira.ui.presenter

import dev.alexferreira.ui.contract.SplashContract
import org.junit.Test
import org.mockito.Mockito

class SplashPresenterTest : AbstractPresenterTest<SplashContract.View, SplashContract.Presenter, SplashPresenter>() {

    @Test
    internal fun whenStarted_callNav() {
        presenter.onViewStarted(null)

        Mockito.verify(view).openMainMenuView()
    }
}