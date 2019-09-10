package dev.alexferreira.data.source.network

import com.google.gson.JsonObject
import retrofit2.http.GET

/**
 * Base URL: https://api.myjson.com/
 */
interface ClienteApi {

    @GET("bins/1bo7qj")
    fun getCliente(): JsonObject

    @GET("bins/wjl97")
    fun getPedidosCliente(): JsonObject
}