package dev.alexferreira.ui.task

import dev.alexferreira.data.model.Cliente
import dev.alexferreira.ui.task.generic.BackgroundResult
import dev.alexferreira.ui.task.generic.DefaultTask
import dev.alexferreira.ui.task.generic.TaskCallback

class LoadClienteTask(callback: TaskCallback<Cliente>) : DefaultTask<Cliente>(callback) {

    override fun doInBackground(vararg params: String?): BackgroundResult<Cliente?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}