package dev.alexferreira.ui.contract

interface IView : NavigatableView {
    fun showErrorMsg(msg: String)
    fun showSucessMsg(msg: String)
    fun showProgressBar()
    fun hideProgressBar()
}