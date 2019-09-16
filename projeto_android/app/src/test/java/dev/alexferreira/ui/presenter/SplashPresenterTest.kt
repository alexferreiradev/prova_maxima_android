package dev.alexferreira.ui.presenter

import dev.alexferreira.ui.contract.SplashContract
import org.junit.Test
import org.mockito.Mockito

class SplashPresenterTest : AbstractPresenterTest<SplashContract.View, SplashContract.Presenter, SplashPresenter>(
    SplashPresenter::class.java, SplashContract.View::class.java
) {

    @Test
    internal fun whenStarted_callNav() {
        contract.onViewStarted(null)

        Mockito.verify(view).getNavigator()
        Mockito.verify(navigator).openMainMenuView()
    }
}