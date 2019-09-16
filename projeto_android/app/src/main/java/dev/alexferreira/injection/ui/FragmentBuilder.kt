package dev.alexferreira.injection.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.alexferreira.injection.scope.FragmentScope
import dev.alexferreira.ui.fragment.AlvaraFragment
import dev.alexferreira.ui.fragment.DadosClienteFragment
import dev.alexferreira.ui.fragment.HistoricoPedidoFragment

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class FragmentBuilder {
    @FragmentScope
    @ContributesAndroidInjector(modules = [PresenterFragModule::class])
    abstract fun contributeDadosClienteFragment(): DadosClienteFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PresenterFragModule::class])
    abstract fun contributeHistoricoPedidoFragment(): HistoricoPedidoFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PresenterFragModule::class])
    abstract fun contributeAlvaraFragment(): AlvaraFragment
}
