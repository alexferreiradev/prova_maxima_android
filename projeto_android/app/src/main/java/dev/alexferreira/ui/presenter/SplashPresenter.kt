package dev.alexferreira.ui.presenter

import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.contract.SplashContract
import javax.inject.Inject

@ActivityScope
class SplashPresenter @Inject constructor() : AbstractPresenter<SplashContract.View>(), SplashContract.Presenter
