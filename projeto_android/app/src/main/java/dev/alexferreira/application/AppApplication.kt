package dev.alexferreira.application

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dev.alexferreira.injection.DaggerApplicationComponent
import timber.log.Timber
import javax.inject.Inject

class AppApplication : Application(), HasActivityInjector {

    @field:[Inject]
    lateinit var actInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return actInjector
    }

    override fun onCreate() {
        DaggerApplicationComponent.builder().application(this).context(this)
            .build().inject(this)
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}