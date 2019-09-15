package dev.alexferreira.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.ui.contract.IFragmentPresenter
import dev.alexferreira.ui.contract.IFragmentView
import dev.alexferreira.ui.contract.Navigator
import javax.inject.Inject

abstract class AbstractFragment<V : IFragmentView, P : IFragmentPresenter<V>> : Fragment(), IFragmentView, Navigator {

    @field:[Inject]
    lateinit var presenter: P

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = this as V
        presenter.onViewCreated(view, context!!, arguments)

        return null
    }

    override fun onStart() {
        super.onStart()
        presenter.onViewStarted(arguments)
    }

    override fun onPause() {
        super.onPause()
        presenter.onViewPaused()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun openMainMenuView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openDadosClienteView(cliente: Cliente) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorMsg(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSucessMsg(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgressBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNavigator(): Navigator {
        return this
    }
}