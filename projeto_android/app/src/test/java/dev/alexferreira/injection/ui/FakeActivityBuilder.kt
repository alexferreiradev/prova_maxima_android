package dev.alexferreira.injection.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.view.DadosClienteActivity
import dev.alexferreira.ui.view.MainMenuActivity
import dev.alexferreira.ui.view.SplashActivity

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class FakeActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [FakePresenterModule::class])
    abstract fun contributeAboutActivityInjector(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [FakePresenterModule::class])
    abstract fun contributeMainMenuActivityInjector(): MainMenuActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [FakePresenterModule::class])
    abstract fun contributeDadosClienteActivityInjector(): DadosClienteActivity
}
