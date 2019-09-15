package dev.alexferreira.ui.task.generic

import timber.log.Timber

interface TaskCallback<Model> {
    fun onError(exception: Throwable) {
        Timber.e(exception)
    }
    fun onEmpty()
    fun onSuccessResult(model: Model)
}