package dev.alexferreira.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import timber.log.Timber

class NetworkStatusReceiver : BroadcastReceiver() {
    override fun onReceive(
            context: Context?,
            intent: Intent?
    ) {
        if (context is Listener) {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            val connected = activeNetwork?.isConnected ?: false
            if (connected) {
                context.onOnlineStatus()
            } else {
                context.onOfflineStatus()
            }
        } else {
            Timber.e("Context de network status receiver não impl: ${Listener::class.java.name}")
        }
    }
    
    interface Listener {
        fun onOfflineStatus()
        fun onOnlineStatus()
    }
}