package dev.alexferreira.ui.presenter

import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.contract.MainMenuContract
import javax.inject.Inject

@ActivityScope
class MainMenuPresenter @Inject constructor() : AbstractPresenter<MainMenuContract.View>(), MainMenuContract.Presenter {

    override fun selectMenuItem() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
