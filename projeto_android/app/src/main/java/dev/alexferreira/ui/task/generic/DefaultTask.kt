package dev.alexferreira.ui.task.generic

import android.os.AsyncTask

abstract class DefaultTask<Model>(var callback: TaskCallback<Model>) :
    AsyncTask<String, Int, BackgroundResult<Model>>() {

    protected var result = BackgroundResult<Model>()

    override fun onPostExecute(result: BackgroundResult<Model>?) {
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
                if (modelIsEmpty(model)) {
                    callback
                        .onError(NullPointerException("Model está nulo sendo que passou nas validações de falha e vazio."))
                } else {
                    callback.onSuccessResult(model!!)
                }
            }
        }
    }

    override fun doInBackground(vararg params: String?): BackgroundResult<Model> {
        try {
            val model = retrieveModel(params)
            if (modelIsEmpty(model)) {
                result.isEmpty = true
            } else {
                result.model = model
            }
        } catch (ex: Exception) {
            result.exception = ex
            result.isFailed = true
        }

        return result
    }

    private fun modelIsEmpty(model: Model?): Boolean {
        if (model == null) {
            return true
        }

        val hasListSuperType = model is List<*>
        if (hasListSuperType) {
            return (model as List<*>).isEmpty()
        }

        return false
    }

    protected abstract fun retrieveModel(params: Array<out String?>): Model?
}