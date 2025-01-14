package dev.alexferreira.injection.ui

import dagger.Binds
import dagger.Module
import dev.alexferreira.injection.scope.FragmentScope
import dev.alexferreira.ui.contract.DadosClienteContract
import dev.alexferreira.ui.presenter.fragment.AlvaraFragPresenter
import dev.alexferreira.ui.presenter.fragment.DadosClienteFragPresenter
import dev.alexferreira.ui.presenter.fragment.HistoricoPedidoFragPresenter

@Module
abstract class PresenterFragModule {
    @FragmentScope
    @Binds
    abstract fun provideDadosCliPresenter(presenter: DadosClienteFragPresenter): DadosClienteContract.DadosClienteFragContract.FragPresenter

    @FragmentScope
    @Binds
    abstract fun provideHistoricoPedidoFragPresenter(presenter: HistoricoPedidoFragPresenter): DadosClienteContract.HistoricoPedidoContract.FragPresenter

    @FragmentScope
    @Binds
    abstract fun provideAlvaraFragPresenter(presenter: AlvaraFragPresenter): DadosClienteContract.AlvaraContract.FragPresenter
}
