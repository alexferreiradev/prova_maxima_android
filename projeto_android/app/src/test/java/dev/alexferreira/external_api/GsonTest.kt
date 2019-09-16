package dev.alexferreira.external_api

import com.google.gson.GsonBuilder
import dev.alexferreira.data.model.Cliente
import org.junit.Assert
import org.junit.Test

class GsonTest {

    @Test
    fun fromJson() {
        val gson = GsonBuilder().create()
        val clienteJson = """{
      "codigo": "40795A",
      "razao_social": "Máxima Sistemas S/A",
      "nomeFantasia": "Máxima Sistemas",
      "cnpj":"10.766.206/002-61",
      "ramo_atividade": "Sistemas",
      "endereco": "Avenida 136 - Setor Sul - Goiânia/Goiás",
      "status": "Indefinido",
      "contatos": [
        {
          "nome":"Gean Delon",
          "telefone": "3333-3365",
          "celular": "62988889888",
          "conjuge": "",
          "tipo": "Sócio",
          "time": "Flamengo",
          "e_mail": "gean.paiva@maximasistemas.com.br",
          "data_nascimento": "1992-12-11",
          "dataNascimentoConjuge": null
        }
      ]
}
        """.trimIndent()
        val fromJson = gson.fromJson(clienteJson, Cliente::class.java)
        Assert.assertNotNull(fromJson)
    }
}