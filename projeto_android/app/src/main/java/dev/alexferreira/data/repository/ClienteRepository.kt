package dev.alexferreira.data.repository

import com.google.gson.Gson
import dev.alexferreira.data.model.Cliente
import dev.alexferreira.data.source.database.ClienteDao
import dev.alexferreira.data.source.database.ContatoClienteDao
import dev.alexferreira.data.source.network.MaximaApi
import dev.alexferreira.injection.scope.ApplicationScope
import timber.log.Timber
import javax.inject.Inject

@ApplicationScope
class ClienteRepository @Inject constructor(
        var maximaApi: MaximaApi,
        var clienteDao: ClienteDao,
        var
        gson: Gson,
        var contatoDao: ContatoClienteDao
) :
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
                Timber.d("Salvando obj em dao")
                clienteDao.save(cliente)
                cliente.contatoList.forEach {
                    it.clienteFK = cliente.id
                    it.id = contatoDao.save(it)
                }
                Timber.d("Retornando obj encontrado em net")
                return cliente
            } else {
                Timber.e("Erro em requisição de cliente: ${execute.errorBody()}")
            }
        } else {
            Timber.d("Retornando obj encontrado em dao, buscando contatos")
            byDao.contatoList = contatoDao.getAllByCliId(byDao.id!!.toString())
            return byDao
        }

        return null
    }

    override fun getAll(): List<Cliente> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
