package dev.alexferreira.ui.presenter

import android.content.Context
import android.content.Intent
import android.support.annotation.StringRes
import dev.alexferreira.service.NetworkStatusReceiver
import dev.alexferreira.ui.contract.INetStatusView
import dev.alexferreira.ui.contract.IPresenter
import dev.alexferreira.ui.contract.IView
import timber.log.Timber

abstract class AbstractPresenter<ViewType : IView> : IPresenter<ViewType>, NetworkStatusReceiver.Listener {
    lateinit var view: ViewType
    lateinit var context: Context
    protected var intent: Intent? = null

    override fun onViewCreated(view: ViewType, context: Context, intent: Intent?) {
        this.view = view
        this.context = context
        this.intent = intent
        validateViewByDecorators()
    }
    
    private fun validateViewByDecorators() {
    }
    
    override fun onOfflineStatus() {
        if (view is INetStatusView) {
            val statusView = view as INetStatusView
            statusView.setOfflineStatusView()
            Timber.d("Trocando para net status: Off")
        }
    }
    
    override fun onOnlineStatus() {
        if (view is INetStatusView) {
            val statusView = view as INetStatusView
            statusView.setOnlineStatusView()
            Timber.d("Trocando para net status: Online")
        }
    }
    
    override fun onViewStarted(intent: Intent?) {

    }

    override fun onViewPaused() {

    }

    override fun onViewDestroyed() {
    }

    protected fun getString(@StringRes stringInt: Int): String {
        return context.getString(stringInt)
    }
}