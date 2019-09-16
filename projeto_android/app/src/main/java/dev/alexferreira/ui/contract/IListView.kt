package dev.alexferreira.ui.contract

interface IListView<M> {
    fun showEmptyView()
    fun showListView()
    fun initListView(modelList: List<M>)
}