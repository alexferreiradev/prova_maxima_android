package dev.alexferreira.ui.contract

import android.content.Context
import android.os.Bundle

interface IFragmentPresenter<ViewType> {
    fun onViewCreated(view: ViewType, context: Context, args: Bundle?)
    fun onViewStarted(args: Bundle?)
    fun onViewPaused()
    fun onViewDestroyed()
}