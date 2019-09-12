package dev.alexferreira.injection.ui

import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.contract.MainMenuContract
import dev.alexferreira.ui.contract.SplashContract

@Module
class FakePresenterModule {
    @ActivityScope
    @Provides
    fun provideSplashPresenter(): SplashContract.Presenter {
        return mock()
    }

    @ActivityScope
    @Provides
    fun provideMainMenuPresenter(): MainMenuContract.Presenter {
        return mock()
    }
}