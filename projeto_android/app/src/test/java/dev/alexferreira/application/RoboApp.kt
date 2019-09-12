package dev.alexferreira.application

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dev.alexferreira.injection.DaggerRoboApplicationComponentTest
import dev.alexferreira.injection.RoboApplicationComponentTest
import timber.log.Timber
import javax.inject.Inject

class RoboApp : Application(), HasActivityInjector {

    lateinit var testComponent: RoboApplicationComponentTest

    @field:[Inject]
    lateinit var actInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return actInjector
    }

    override fun onCreate() {
        testComponent = DaggerRoboApplicationComponentTest.builder().application(this).context(this).build()
        testComponent.inject(this)
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
