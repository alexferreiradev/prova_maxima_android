package dev.alexferreira.ui.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dev.alexferreira.R
import dev.alexferreira.helper.ViewHelper
import dev.alexferreira.ui.contract.IPresenter
import dev.alexferreira.ui.contract.IView
import dev.alexferreira.ui.contract.Navigator
import javax.inject.Inject

abstract class AbstractView<ViewType : IView, PresenterType : IPresenter<ViewType>> : AppCompatActivity(),
    IView, Navigator {
    @field:[Inject]
    lateinit var presenter: PresenterType
    lateinit var view: ViewType

    private fun initDagger() {
        AndroidInjection.inject(this)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        initDagger()
        super.onCreate(savedInstanceState)
        validateDecoratorsConfig()
        view = castToViewType()
        presenter.onViewCreated(view, applicationContext, intent)
    }

    @Suppress("UNCHECKED_CAST")
    private fun castToViewType(): ViewType {
        try {
            return this as ViewType
        } catch (e: ClassCastException) {
            throw IllegalArgumentException("View não implementa contrato de view", e)
        }
    }

    private fun validateDecoratorsConfig() {

    }

    override fun onStart() {
        super.onStart()
        presenter.onViewStarted(intent)
    }

    override fun onPause() {
        super.onPause()
        presenter.onViewPaused()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun showErrorMsg(msg: String) {
        ViewHelper.showErrorMsg(this, msg)
    }

    override fun showSucessMsg(msg: String) {
        ViewHelper.showSuccessMsg(this, msg)
    }

    override fun showProgressBar() {
//        ViewHelper.setViewVisible(progress_bar)
    }

    override fun hideProgressBar() {
//        ViewHelper.hideView(progress_bar)
    }

    override fun getNavigator(): Navigator {
        return this
    }

    override fun openMainMenuView() {
        startActivity(
            Intent(
                this,
                MainMenuActivity::class.java
            )
        )
    }

    override fun openDadosClienteView(id: String) {
        startActivity(
            Intent(
                this,
                DadosClienteActivity::class.java
            ).apply { putExtra(getString(R.string.cliente_id_intent_key), id) })
    }
}