package dev.alexferreira.application

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import dev.alexferreira.injection.DaggerRoboApplicationComponentTest
import dev.alexferreira.injection.RoboApplicationComponentTest
import timber.log.Timber
import javax.inject.Inject

class RoboApp : Application(), HasActivityInjector, HasSupportFragmentInjector {

    lateinit var testComponent: RoboApplicationComponentTest

    @field:[Inject]
    lateinit var actInjector: DispatchingAndroidInjector<Activity>

    @field:[Inject]
    lateinit var fragInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> {
        return actInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragInjector
    }

    override fun onCreate() {
        testComponent = DaggerRoboApplicationComponentTest.builder().application(this).context(this).build()
        testComponent.inject(this)
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
