package dev.alexferreira.ui.view

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dev.alexferreira.R
import dev.alexferreira.helper.ViewHelper
import dev.alexferreira.service.NetworkStatusReceiver
import dev.alexferreira.ui.contract.INetStatusView
import dev.alexferreira.ui.contract.IPresenter
import dev.alexferreira.ui.contract.IView
import dev.alexferreira.ui.contract.Navigator
import timber.log.Timber
import javax.inject.Inject

abstract class AbstractView<ViewType : IView, PresenterType : IPresenter<ViewType>> : AppCompatActivity(),
        IView, Navigator, NetworkStatusReceiver.Listener {
    @field:[Inject]
    lateinit var presenter: PresenterType
    lateinit var view: ViewType
    private var networkStatusReceiver: NetworkStatusReceiver? = null
    
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
    
    private fun startNetworkStatusReceiver() {
        if (this is INetStatusView) {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Timber.d("Iniciando callback para network change")
                cm.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network?) {
                        onOnlineStatus()
                    }
                    
                    override fun onLost(network: Network?) {
                        onOfflineStatus()
                    }
                })
            } else {
                Timber.d("Iniciando broadcast receiver para network change")
                networkStatusReceiver = NetworkStatusReceiver()
                @Suppress("DEPRECATION") // Usando nova forma no IF acima
                registerReceiver(
                        networkStatusReceiver,
                        IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
                )
            }
        }
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
        if (this is INetStatusView) {
            if (presenter !is NetworkStatusReceiver.Listener) {
                throw IllegalArgumentException(
                        "Presenter deve implementar: ${NetworkStatusReceiver
                                .Listener::class.java.name}"
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.onViewStarted(intent)
        startNetworkStatusReceiver()
    }

    override fun onPause() {
        super.onPause()
        presenter.onViewPaused()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
        unRegisterNetStatusReceiver()
    }
    
    private fun unRegisterNetStatusReceiver() {
        if (this is INetStatusView && networkStatusReceiver != null) {
            unregisterReceiver(networkStatusReceiver)
        }
    }
    
    override fun onOfflineStatus() {
        if (presenter is NetworkStatusReceiver.Listener) {
            val listener = presenter as NetworkStatusReceiver.Listener
            listener.onOfflineStatus()
        }
    }
    
    override fun onOnlineStatus() {
        if (presenter is NetworkStatusReceiver.Listener) {
            val listener = presenter as NetworkStatusReceiver.Listener
            listener.onOnlineStatus()
        }
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