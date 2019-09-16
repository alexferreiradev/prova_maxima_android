package dev.alexferreira.ui.presenter.fragment

import android.content.Context
import android.os.Bundle
import dev.alexferreira.ui.contract.IFragmentPresenter
import dev.alexferreira.ui.contract.IFragmentView

abstract class AbstractFragPresenter<V : IFragmentView> : IFragmentPresenter<V> {

    protected lateinit var view: V
    protected lateinit var context: Context
    protected var args: Bundle? = null

    protected var viewNotPaused = true

    override fun onViewCreated(view: V, context: Context, args: Bundle?) {
        this.view = view
        this.context = context
        this.args = args
    }

    override fun onViewStarted(args: Bundle?) {
        this.args = args
    }

    override fun onViewPaused() {
        viewNotPaused = false
    }

    override fun onViewDestroyed() {
    }
}