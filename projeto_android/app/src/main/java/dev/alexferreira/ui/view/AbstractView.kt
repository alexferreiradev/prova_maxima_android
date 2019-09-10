package dev.alexferreira.ui.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dev.alexferreira.ui.contract.IPresenter
import dev.alexferreira.ui.contract.IView
import javax.inject.Inject

abstract class AbstractView<ViewType : IView, PresenterType : IPresenter<ViewType>> : AppCompatActivity(),
    IView {
    @field:[Inject]
    lateinit var presenter: PresenterType

    abstract fun getSubView(): ViewType

    private fun initDagger() {
        AndroidInjection.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initDagger()
        validateDecoratorsConfig()
        super.onCreate(savedInstanceState)
    }

    private fun validateDecoratorsConfig() {

    }

    override fun onStart() {
        super.onStart()
        presenter.onViewStarted(intent)
    }

    override fun onStop() {
        super.onStop()
        presenter.onViewDestroyed()
    }

    override fun showErrorMsg(msg: String) {
//        ViewHelper.showErrorMsg(this, msg)
    }

    override fun showSucessMsg(msg: String) {
//        ViewHelper.showSuccessMsg(this, msg)
    }

    override fun showProgressBar() {
//        ViewHelper.setViewVisible(progress_bar)
    }

    override fun hideProgressBar() {
//        ViewHelper.hideView(progress_bar)
    }
}