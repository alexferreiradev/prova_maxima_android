package dev.alexferreira.injection

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dev.alexferreira.application.RoboApp
import dev.alexferreira.injection.scope.ApplicationScope
import dev.alexferreira.injection.ui.FakeActivityBuilder
import dev.alexferreira.injection.ui.FakeFragmentBuilder

@ApplicationScope
@Component(modules = [FakeActivityBuilder::class, FakeFragmentBuilder::class])
interface RoboApplicationComponentTest : AndroidInjector<RoboApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(application: Context): Builder

        fun build(): RoboApplicationComponentTest
    }
}