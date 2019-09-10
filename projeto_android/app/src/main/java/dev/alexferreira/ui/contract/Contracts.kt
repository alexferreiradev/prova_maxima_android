package dev.alexferreira.ui.contract

interface SplashContract {
    interface View : IView
    interface Presenter : IPresenter<View>
}

interface MainMenuContract {
    interface View : IView
    interface Presenter : IPresenter<View>
}

interface ClienteInfoContract {
    interface View : IView
    interface Presenter : IPresenter<View>
}

interface PedidoInfoContract {
    interface View : IView
    interface Presenter : IPresenter<View>
}