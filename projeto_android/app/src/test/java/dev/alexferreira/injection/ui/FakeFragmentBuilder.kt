package dev.alexferreira.injection.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.alexferreira.injection.scope.FragmentScope
import dev.alexferreira.ui.fragment.AlvaraFragment
import dev.alexferreira.ui.fragment.DadosClienteFragment
import dev.alexferreira.ui.fragment.HistoricoPedidoFragment

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class FakeFragmentBuilder {
    @FragmentScope
    @ContributesAndroidInjector(modules = [FakePresenterFragModule::class])
    abstract fun contributeDadosClienteFragmentInjector(): DadosClienteFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FakePresenterFragModule::class])
    abstract fun contributeHistoricoPedidoFragmentInjector(): HistoricoPedidoFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FakePresenterFragModule::class])
    abstract fun contributeAlvaraFragmentInjector(): AlvaraFragment
}
