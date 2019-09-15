package dev.alexferreira.ui.task

import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.data.repository.IPedidoClienteRepository
import dev.alexferreira.ui.task.generic.DefaultTask
import dev.alexferreira.ui.task.generic.TaskCallback

class LoadPedidoClienteTask(
    callback: TaskCallback<List<PedidoCliente>>,
    val repo: IPedidoClienteRepository
) : DefaultTask<List<PedidoCliente>>(callback) {

    override fun retrieveModel(params: Array<out String?>): List<PedidoCliente>? {
        return repo.getAll()
    }
}