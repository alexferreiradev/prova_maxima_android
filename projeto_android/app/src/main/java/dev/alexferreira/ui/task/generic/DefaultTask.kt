package dev.alexferreira.ui.task.generic

import android.os.AsyncTask

abstract class DefaultTask<Model>(var callback: TaskCallback<Model>) :
    AsyncTask<String, Int, BackgroundResult<Model?>>() {
    override fun onPostExecute(result: BackgroundResult<Model?>?) {
        super.onPostExecute(result)
        if (isCancelled) {
            return
        }

        if (result == null) {
            callback.onEmpty()
            return
        }

        if (result.isFailed) {
            callback.onError(result.exception!!)
        } else {
            if (result.isEmpty) {
                callback.onEmpty()
            } else {
                val model = result.model
                if (model == null) {
                    callback
                        .onError(NullPointerException("Model está nulo sendo que passou nas validações de falha e vazio."))
                } else {
                    callback.onSuccessResult(model)
                }
            }
        }
    }
}