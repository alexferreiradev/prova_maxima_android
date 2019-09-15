package dev.alexferreira.ui.contract

import android.view.MenuItem
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.ui.model.MainMenuModel

interface SplashContract {
    interface View : IView
    interface Presenter : IPresenter<View>
}

interface MainMenuContract {
    interface View : IView {
        fun initAdapter(menuList: MutableList<MainMenuModel>)
    }

    interface Presenter : IPresenter<View> {
        fun selectMenuItem(menuItem: MainMenuModel)
    }
}

interface DadosClienteContract {
    interface View : IView {
        fun initViewPager(cliente: Cliente)
        fun setViewPagerPos(pos: Int)
    }

    interface Presenter : IPresenter<View>, SharedView {
        fun selectBottomNavItemMenu(menuItem: MenuItem): Boolean
    }

    interface SharedView

    interface SubView

    interface DadosClienteFragContract {
        interface FragView : IFragmentView, SubView {
            fun showSnackBarMsg(msg: String)
            fun showEmptyLayout()
            fun showListView()
            fun initDadosList(model: Cliente)
        }

        interface FragPresenter : IFragmentPresenter<FragView> {
            fun selectVerifyEstadoCliente()
        }
    }

    interface HistoricoPedidoContract {
        interface FragView : IFragmentView, SubView
        interface FragPresenter : IFragmentPresenter<FragView>
    }

    interface AlvaraContract {
        interface FragView : IView, SubView
        interface FragPresenter : IPresenter<FragView>
    }

}