package dev.alexferreira.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import dev.alexferreira.R
import dev.alexferreira.helper.ViewHelper
import dev.alexferreira.ui.contract.IFragmentPresenter
import dev.alexferreira.ui.contract.IFragmentView
import dev.alexferreira.ui.contract.Navigator
import org.jetbrains.anko.find
import javax.inject.Inject

abstract class AbstractFragment<V : IFragmentView, P : IFragmentPresenter<V>> : Fragment(), IFragmentView, Navigator {

    @field:[Inject]
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = this as V
        presenter.onViewCreated(view, requireContext(), arguments)

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
    }

    override fun openDadosClienteView(id: String) {
    }

    override fun showErrorMsg(msg: String) {
        ViewHelper.showErrorMsg(requireContext(), msg)
    }

    override fun showSucessMsg(msg: String) {
        ViewHelper.showSuccessMsg(requireContext(), msg)
    }

    override fun showProgressBar() {
        ViewHelper.setViewVisible(view?.find(R.id.progressBar))
    }

    override fun hideProgressBar() {
        ViewHelper.hideView(view?.find(R.id.progressBar))
    }

    override fun getNavigator(): Navigator {
        return this
    }
}