package dev.alexferreira.ui.presenter

import android.content.Intent
import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.contract.SplashContract
import javax.inject.Inject

@ActivityScope
class SplashPresenter @Inject constructor() : AbstractPresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun onViewStarted(intent: Intent?) {
        super.onViewStarted(intent)
        view.getNavigator().openMainMenuView()
    }
}
