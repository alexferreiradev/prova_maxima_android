package dev.alexferreira.ui.presenter

import dev.alexferreira.R
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.contract.MainMenuContract
import dev.alexferreira.ui.model.MainMenuModel
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class MainMenuPresenter @Inject constructor() : AbstractPresenter<MainMenuContract.View>(), MainMenuContract.Presenter {

    lateinit var currentCliente: Cliente

    override fun selectMenuItem(menuItem: MainMenuModel) {
        when (menuItem.title) {
            context.getString(R.string.dados_cliente_main_menu_title) -> {
                view.getNavigator().openDadosClienteView(currentCliente)
            }
            else -> {
                Timber.e("Click de menu com titulo: ${menuItem.title} está sendo ignorado")
            }
        }
    }
}
