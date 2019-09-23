package dev.alexferreira.application

import android.app.Activity
import android.app.Application
import android.arch.persistence.room.Room
import android.content.Intent
import android.content.IntentFilter
import android.support.v4.app.Fragment
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.gson.GsonBuilder
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import dev.alexferreira.data.source.database.AbstractDataBase
import dev.alexferreira.injection.DaggerApplicationComponent
import dev.alexferreira.service.BootReceiver
import dev.alexferreira.service.worker.NotificationWorker
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AppApplication : Application(), HasActivityInjector, HasSupportFragmentInjector, BootReceiver.Listener {

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

    override fun onBoot(intent: Intent?) {
        startNotificationService()
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
        startBootReceiver()
        startNotificationService()
    }

    private fun startNotificationService() {
        val workRequest = PeriodicWorkRequestBuilder<NotificationWorker>(15, TimeUnit.MINUTES)
            .setConstraints(Constraints.Builder().setRequiresBatteryNotLow(true).build())
            .build()
        WorkManager.getInstance()
                .enqueueUniquePeriodicWork(
                        "notification",
                        ExistingPeriodicWorkPolicy.REPLACE,
                        workRequest
                )
    }

    private fun startBootReceiver() {
        registerReceiver(BootReceiver(), IntentFilter(Intent.ACTION_BOOT_COMPLETED))
    }

    companion object {
        private const val DATABASE_NAME = "maxima.db"
    }
}