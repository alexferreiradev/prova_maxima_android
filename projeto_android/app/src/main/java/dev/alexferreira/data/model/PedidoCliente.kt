package dev.alexferreira.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class PedidoCliente(
    @PrimaryKey val id: Long,
    @SerializedName("numero_ped_Rca") val numeroPedRca: Long? = null,
    @SerializedName(
        "numero_ped_erp"
    ) val numeroPedERP: String = "",
    @SerializedName("codigoCliente") val codigoCliente: String = "",
    @SerializedName(
        "NOMECLIENTE"
    ) val nomeCliente: String = "",
    val data: String = "",
    val status: StatusPedido? = null,
    val critica: CriticaPedido? = null,
    val tipo: TipoPedido? = null,
    val legendas: List<String> = emptyList()
) : Parcelable {
    companion object {
        const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssSSSS"
    }
}