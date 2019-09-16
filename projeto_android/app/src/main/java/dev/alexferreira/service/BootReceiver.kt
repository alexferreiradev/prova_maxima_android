package dev.alexferreira.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context is Listener) {
            // Prevent others send another action
            if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
                context.onBoot(intent)
            }
        } else {
            throw IllegalArgumentException("Context de boot receiver deve implementar Listener")
        }
    }

    interface Listener {
        fun onBoot(intent: Intent?)
    }
}