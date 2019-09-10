package dev.alexferreira.ui.presenter

import android.content.Context
import android.content.Intent
import dev.alexferreira.ui.contract.IPresenter
import dev.alexferreira.ui.contract.IView

abstract class AbstractPresenter<ViewType : IView> : IPresenter<ViewType> {
    var viewContract: ViewType? = null
    var contextRef: Context? = null

    override fun onViewCreated(view: ViewType, context: Context, intent: Intent) {
        this.viewContract = view
        this.contextRef = context
    }

    override fun onViewStarted(intent: Intent) {

    }

    override fun onViewPaused() {

    }

    override fun onViewDestroyed() {
    }
}