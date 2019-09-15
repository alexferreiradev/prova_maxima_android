package dev.alexferreira.injection.ui

import dagger.Binds
import dagger.Module
import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.contract.MainMenuContract
import dev.alexferreira.ui.contract.SplashContract
import dev.alexferreira.ui.presenter.DadosClientePresenter
import dev.alexferreira.ui.presenter.MainMenuPresenter
import dev.alexferreira.ui.presenter.SplashPresenter

@Module
abstract class PresenterModule {
    @ActivityScope
    @Binds
    abstract fun provideSplashPresenter(presenter: SplashPresenter): SplashContract.Presenter

    @ActivityScope
    @Binds
    abstract fun provideMainMenuPresenter(presenter: MainMenuPresenter): MainMenuContract.Presenter

    @ActivityScope
    @Binds
    abstract fun provideDadosClientePresenter(presDadosClientePresenter: DadosClientePresenter): DadosClienteContract.Presenter
}
