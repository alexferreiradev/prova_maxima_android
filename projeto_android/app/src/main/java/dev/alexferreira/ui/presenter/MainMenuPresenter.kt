package dev.alexferreira.ui.presenter

import android.content.Intent
import dev.alexferreira.BuildConfig
import dev.alexferreira.R
import dev.alexferreira.injection.scope.ActivityScope
import dev.alexferreira.ui.contract.MainMenuContract
import dev.alexferreira.ui.model.MainMenuModel
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class MainMenuPresenter @Inject constructor() : AbstractPresenter<MainMenuContract.View>(), MainMenuContract.Presenter {

    override fun selectMenuItem(menuItem: MainMenuModel) {
        when (menuItem.title) {
            context.getString(R.string.dados_cliente_main_menu_title) -> {
                // Não existe o cliente ainda, entao coloquei fixo, deveria ter uma lista de clientes antes
                view.getNavigator().openDadosClienteView("30987")
            }
            else -> {
                Timber.e("Click de menu com titulo: ${menuItem.title} está sendo ignorado")
            }
        }
    }

    override fun onViewStarted(intent: Intent?) {
        super.onViewStarted(intent)
        val menuList = createMenus()
        view.initAdapter(menuList)
        view.setVersionText(BuildConfig.VERSION_NAME)
    }

    private fun createMenus(): MutableList<MainMenuModel> {
        val menuList = ArrayList<MainMenuModel>()
        menuList.add(MainMenuModel(R.drawable.ic_maxima_pessoas, getString(R.string.dados_cliente_main_menu_title)))
        menuList.add(MainMenuModel(R.drawable.ic_maxima_pedido, getString(R.string.pedido_main_menu_title)))
        menuList.add(
            MainMenuModel(
                R.drawable.ic_maxima_resumo_vendas,
                getString(R.string.resumo_vendas_main_menu_title)
            )
        )
        menuList.add(MainMenuModel(R.drawable.ic_maxima_ferramentas, getString(R.string.ferramentas_main_menu_title)))

        return menuList
    }
}
