package dev.alexferreira.injection

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dev.alexferreira.application.AppApplication
import dev.alexferreira.injection.scope.ApplicationScope
import dev.alexferreira.injection.ui.ActivityBuilder

@ApplicationScope
@Component(
    modules = [ActivityBuilder::class
//        modules = [ActivityBuilder::class,
//            RepositoryModule::class]
    ]
)
interface ApplicationComponent : AndroidInjector<AppApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(application: Context): Builder

        //        fun repositoryModule(repositoryModule: RepositoryModule): Builder
        fun build(): ApplicationComponent
    }
}