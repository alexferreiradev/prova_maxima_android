package dev.alexferreira.ui.contract

interface IFragmentView : NavigatableView {
    fun showErrorMsg(msg: String)
    fun showSucessMsg(msg: String)
    fun showProgressBar()
    fun hideProgressBar()
}