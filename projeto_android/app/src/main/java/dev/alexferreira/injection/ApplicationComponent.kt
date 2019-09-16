package dev.alexferreira.injection

import android.app.Application
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dev.alexferreira.application.AppApplication
import dev.alexferreira.injection.data.NetworkModule
import dev.alexferreira.injection.data.RepositoryModule
import dev.alexferreira.injection.data.SourceModule
import dev.alexferreira.injection.scope.ApplicationScope
import dev.alexferreira.injection.ui.ActivityBuilder
import dev.alexferreira.injection.ui.FragmentBuilder

@ApplicationScope
@Component(
    modules = [
        ActivityBuilder::class,
        FragmentBuilder::class,
        RepositoryModule::class,
        SourceModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<AppApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        @BindsInstance
        fun context(application: Context): Builder

        @BindsInstance
        fun dataBase(database: RoomDatabase): Builder

        @BindsInstance
        fun gson(gson: Gson): Builder

        fun build(): ApplicationComponent
    }
}