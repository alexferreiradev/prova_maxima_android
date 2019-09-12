package dev.alexferreira.injection.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.view.MainMenuActivity
import dev.alexferreira.ui.view.SplashActivity

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [PresenterModule::class])
    abstract fun contributeAboutActivityInjector(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [PresenterModule::class])
    abstract fun contributeMainMenuActivityInjector(): MainMenuActivity
}
