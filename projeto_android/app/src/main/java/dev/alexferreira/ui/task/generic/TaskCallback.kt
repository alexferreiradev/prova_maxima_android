package dev.alexferreira.ui.task.generic

interface TaskCallback<Model> {
    fun onError(exception: Throwable)
    fun onEmpty()
    fun onSuccessResult(model: Model)
}