package dev.alexferreira.data.repository

import com.google.gson.Gson
import com.google.gson.JsonObject
import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.data.source.database.PedidoClienteDao
import dev.alexferreira.data.source.network.MaximaApi
import dev.alexferreira.injection.scope.ApplicationScope
import timber.log.Timber
import javax.inject.Inject

@ApplicationScope
class PedidoClienteRepository @Inject constructor(var maximaApi: MaximaApi, var dao: PedidoClienteDao, var gson: Gson) :
    IPedidoClienteRepository {

    override fun getAll(): List<PedidoCliente> {
        // TODO ${DATE} - Adicionar
        return ArrayList()
    }

    override fun getAllByCliId(id: String?): List<PedidoCliente> {
        if (id.isNullOrEmpty()) {
            return ArrayList()
        }

        val modelList = ArrayList<PedidoCliente>()
        val byDao = dao.getAllByClienteId(id)
        if (byDao.isEmpty()) {
            val response = maximaApi.getPedidosCliente().execute()
            if (response.isSuccessful) {
                val jsonObject = response.body()!!
                modelList.addAll(createListFromJson(jsonObject))
                Timber.d("Salvando obj em dao")
                dao.saveAll(modelList)
            } else {
                Timber.e("Erro de resposta de pedido: ${response.errorBody()}")
            }
        } else {
            Timber.d("Retornando obj encontrado em dao")
            return byDao
        }

        Timber.d("Retornando obj encontrado em net")
        return modelList
    }

    private fun createListFromJson(jsonObject: JsonObject): Collection<PedidoCliente> {
        val modelList = ArrayList<PedidoCliente>()
        val jsonArray = jsonObject["pedidos"].asJsonArray
        jsonArray.forEach {
            val pedidoCliente = gson.fromJson(it.asJsonObject, PedidoCliente::class.java)
            modelList.add(pedidoCliente)
        }

        return modelList
    }
}
