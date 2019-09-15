package dev.alexferreira.injection.ui

import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import dev.alexferreira.injection.scope.FragmentScope
import dev.alexferreira.ui.contract.DadosClienteContract

@Module
class FakePresenterFragModule {
    @FragmentScope
    @Provides
    fun provideDadosClienteFragPresenter(): DadosClienteContract.DadosClienteFragContract.FragPresenter {
        return mock()
    }
}