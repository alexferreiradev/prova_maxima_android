package dev.alexferreira.injection.ui

import dagger.Binds
import dagger.Module
import dev.alexferreira.injection.scope.FragmentScope
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.presenter.fragment.DadosClienteFragPresenter

@Module
abstract class PresenterFragModule {
    @FragmentScope
    @Binds
    abstract fun provideDadosCliPresenter(presenter: DadosClienteFragPresenter): DadosClienteContract.DadosClienteFragContract.FragPresenter
}
