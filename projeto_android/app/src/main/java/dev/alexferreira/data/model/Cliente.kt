package dev.alexferreira.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Cliente(
    @PrimaryKey
    val id: Long,
    @ColumnInfo
    val codigo: String,
    @ColumnInfo
    @SerializedName("razao_social")
    val razaoSocial: String,
    @ColumnInfo
    val nomeFantasia: String,
    @ColumnInfo
    val cnpj: String,
    @SerializedName("ramo_atividade")
    @ColumnInfo
    val ramoAtividade: String,
    @ColumnInfo
    val endereco: String,
    @ColumnInfo
    val status: StatusCliente,
    @SerializedName("contatos")
    @ColumnInfo
    val contatoList: List<ClienteContato>
) : Parcelable

@Parcelize
data class ClienteContato(
    @PrimaryKey
    val id: Long,
    @ColumnInfo
    val nome: String,
    @ColumnInfo
    val telefone: String,
    @ColumnInfo
    val celular: String,
    @ColumnInfo
    val conjugue: String,
    @ColumnInfo
    val tipo: String,
    @ColumnInfo
    val time: String,
    @ColumnInfo
    @SerializedName("e_mail")
    val email: String,
    @ColumnInfo
    @SerializedName("data_nascimento")
    val dataNasc: String,
    @ColumnInfo
    @SerializedName("dataNascimentoConjuge")
    val dataNascConjugue: String
) : Parcelable
