package dev.alexferreira.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Cliente(
    @field:[PrimaryKey] var id: Long? = null,
    @field:[ColumnInfo] var codigo: String = "",
    @field:[ColumnInfo SerializedName("razao_social")] var razaoSocial: String = "",
    @field:[ColumnInfo] var nomeFantasia: String = "",
    @field:[ColumnInfo] var cnpj: String = "",
    @field:[ColumnInfo SerializedName("ramo_atividade")] var ramoAtividade: String = "",
    @field:[ColumnInfo] var endereco: String = "",
    @field:[ColumnInfo] var status: StatusCliente? = null,
    @field:[ColumnInfo SerializedName("contatos") Ignore] var contatoList:
    List<ClienteContato> = emptyList()
) : Parcelable

@Parcelize
data class ClienteContato(
    @field:[PrimaryKey] var id: Long? = null,
    @field:[ColumnInfo] var clienteFK: Long? = null,
    @field:[ColumnInfo] var nome: String = "",
    @field:[ColumnInfo] var telefone: String = "",
    @field:[ColumnInfo] var celular: String = "",
    @field:[ColumnInfo] var conjugue: String = "",
    @field:[ColumnInfo] var tipo: String = "",
    @field:[ColumnInfo] var time: String = "",
    @field:[ColumnInfo SerializedName("e_mail")] var email: String = "",
    @field:[ColumnInfo SerializedName("data_nascimento")] var dataNasc: String = "",
    @field:[ColumnInfo SerializedName("dataNascimentoConjuge")] var dataNascConjugue: String = ""
) : Parcelable
