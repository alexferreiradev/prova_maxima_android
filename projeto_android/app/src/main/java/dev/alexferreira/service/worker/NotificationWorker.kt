package dev.alexferreira.service.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.content.ContextCompat.getSystemService
import androidx.work.Worker
import androidx.work.WorkerParameters
import dev.alexferreira.R
import dev.alexferreira.ui.view.SplashActivity
import timber.log.Timber
import java.util.*


class NotificationWorker(var context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        Timber.d("Iniciando worker de notificacao")
        val pi = PendingIntent.getActivity(
            context, 0,
            Intent(context, SplashActivity::class.java),
            Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        )

        val idParam = "main_channel"
        createNotificationChannel(context, idParam)
        val notification = NotificationCompat.Builder(context, idParam)
            .setContentTitle(context.getString(R.string.notification_title))
            .setContentText(context.getString(R.string.notification_content))
            .setAutoCancel(false)
            .setContentIntent(pi)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setShowWhen(true)
            .setColor(Color.RED)
            .setLocalOnly(true)
            .build()
        NotificationManagerCompat.from(context)
            .notify(Random().nextInt(), notification)

        Timber.d("Fim worker de notificacao")

        return Result.success()
    }

    private fun createNotificationChannel(context: Context, idParam: String) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Timber.d("Iniciando channel de notificacao")
            val name = context.getString(R.string.notfication_channel_name)
            val descriptionText = context.getString(R.string.notfication_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(idParam, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(context, NotificationManager::class.java) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        } else {
            Timber.d("Dispositivo não compatível com channel")
        }
    }

}