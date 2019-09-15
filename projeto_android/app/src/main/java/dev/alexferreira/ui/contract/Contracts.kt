package dev.alexferreira.ui.contract

import android.view.MenuItem
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
        fun initViewPager()
        fun setViewPagerPos(pos: Int)
    }

    interface Presenter : IPresenter<View>, SharedView {
        fun selectBottomNavItemMenu(menuItem: MenuItem)
    }

    interface SharedView

    interface SubView

    interface DadosClienteContract {
        interface FragView : IFragmentView, SubView
        interface FragPresenter : IFragmentPresenter<IFragmentView> {
            fun selectVerifyEstadoCliente()
        }
    }

    interface HistoricoPedidoContract {
        interface FragView : IFragmentView, SubView
        interface FragPresenter : IFragmentPresenter<IFragmentView>
    }

    interface AlvaraContract {
        interface FragView : IView, SubView
        interface FragPresenter : IPresenter<View>
    }

}