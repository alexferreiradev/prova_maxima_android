package dev.alexferreira.ui.task

import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.repository.IClienteRepository
import dev.alexferreira.ui.task.generic.DefaultTask
import dev.alexferreira.ui.task.generic.TaskCallback

class LoadClienteTask(
    callback: TaskCallback<Cliente>,
    val cliRepo: IClienteRepository
) : DefaultTask<Cliente>(callback) {

    override fun retrieveModel(params: Array<out String?>): Cliente? {
        return cliRepo.getCliente(params[0])
    }
}