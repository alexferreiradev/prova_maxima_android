package dev.alexferreira.ui.contract

import android.content.Context
import android.content.Intent

interface IPresenter<ViewType> {
    fun onViewCreated(view: ViewType, context: Context, intent: Intent)
    fun onViewStarted(intent: Intent)
    fun onViewPaused()
    fun onViewDestroyed()
}