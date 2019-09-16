package dev.alexferreira.data.repository

import com.google.gson.Gson
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.source.database.ClienteDao
import dev.alexferreira.data.source.network.MaximaApi
import dev.alexferreira.injection.scope.ApplicationScope
import timber.log.Timber
import javax.inject.Inject

@ApplicationScope
class ClienteRepository @Inject constructor(var maximaApi: MaximaApi, var clienteDao: ClienteDao, var gson: Gson) :
    IClienteRepository {

    override fun getCliente(id: String?): Cliente? {
        if (id == null) {
            return null
        }

        val byDao = clienteDao.getById(id)
        if (byDao == null) {
            val execute = maximaApi.getCliente().execute()
            if (execute.isSuccessful) {
                val jsonObject = execute.body()!!
                val cliente = gson.fromJson(jsonObject["cliente"].asJsonObject, Cliente::class.java)
                clienteDao.save(cliente)
                return cliente
            } else {
                Timber.e("Erro em requisição de cliente: ${execute.errorBody()}")
            }
        } else {
            return byDao
        }

        return null
    }

    override fun getAll(): List<Cliente> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
