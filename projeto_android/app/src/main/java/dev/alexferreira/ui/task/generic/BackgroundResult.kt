package dev.alexferreira.ui.task.generic

class BackgroundResult<Model> {
    var isFailed: Boolean = false
    var isEmpty: Boolean = false
    var exception: Throwable? = null
    var model: Model? = null
}