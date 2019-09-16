package dev.alexferreira.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class PedidoCliente(
    @field:[PrimaryKey] var id: Long? = null,
    @field:[ColumnInfo SerializedName("numero_ped_Rca")] var numeroPedRca: Long? = null,
    @field:[ColumnInfo SerializedName(
        "numero_ped_erp"
    )] var numeroPedERP: String = "",
    @field:[ColumnInfo SerializedName("codigoCliente")] var codigoCliente: String = "",
    @field:[ColumnInfo SerializedName(
        "NOMECLIENTE"
    )] var nomeCliente: String = "",
    @field:[ColumnInfo] var data: String = "",
    @field:[ColumnInfo] var status: StatusPedido? = null,
    @field:[ColumnInfo] var critica: CriticaPedido? = null,
    @field:[ColumnInfo] var tipo: TipoPedido? = null,
    @field:[ColumnInfo] var legendas: List<String> = emptyList()
) : Parcelable {
    companion object {
        const val DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ssSSSS"
    }
}