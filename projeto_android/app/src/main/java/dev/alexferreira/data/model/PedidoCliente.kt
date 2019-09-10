package dev.alexferreira.data.model

import android.arch.persistence.room.Entity
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class PedidoCliente(
    @SerializedName("numero_ped_Rca")
    val numeroPedRca: Long,
    @SerializedName("numero_ped_erp")
    val numeroPedERP: String,
    @SerializedName("codigoCliente")
    val codigoCliente: String,
    @SerializedName("NOMECLIENTE")
    val nomeCliente: String,
    val data: String,
    val status: StatusPedido,
    val critica: CriticaPedido,
    val tipo: TipoPedido,
    val legendas: List<String>
) : Parcelable