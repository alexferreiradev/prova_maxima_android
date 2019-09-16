package dev.alexferreira.application

import android.app.Activity
import android.app.Application
import android.arch.persistence.room.Room
import android.support.v4.app.Fragment
import com.google.gson.GsonBuilder
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import dev.alexferreira.data.source.database.AbstractDataBase
import dev.alexferreira.injection.DaggerApplicationComponent
import timber.log.Timber
import javax.inject.Inject

class AppApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

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
        val dataBase =
            Room.databaseBuilder(this, AbstractDataBase::class.java, DATABASE_NAME).fallbackToDestructiveMigration()
                .build()
        val gson = GsonBuilder().create()
        DaggerApplicationComponent.builder().application(this).context(this)
            .dataBase(dataBase)
            .gson(gson)
            .build().inject(this)
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        private const val DATABASE_NAME = "maxima.db"
    }
}