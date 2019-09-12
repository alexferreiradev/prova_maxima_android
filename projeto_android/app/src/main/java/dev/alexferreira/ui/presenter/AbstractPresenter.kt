package dev.alexferreira.ui.presenter

import android.content.Context
import android.content.Intent
import dev.alexferreira.ui.contract.IPresenter
import dev.alexferreira.ui.contract.IView

abstract class AbstractPresenter<ViewType : IView> : IPresenter<ViewType> {
    lateinit var view: ViewType
    lateinit var context: Context

    override fun onViewCreated(view: ViewType, context: Context, intent: Intent?) {
        this.view = view
        this.context = context
    }

    override fun onViewStarted(intent: Intent?) {

    }

    override fun onViewPaused() {

    }

    override fun onViewDestroyed() {
    }
}