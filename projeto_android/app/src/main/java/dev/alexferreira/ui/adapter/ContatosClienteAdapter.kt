package dev.alexferreira.ui.adapter

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.alexferreira.R
import dev.alexferreira.data.model.ClienteContato
import org.jetbrains.anko.find

class ContatosClienteAdapter(
        private val context: Context,
        private val modelList: MutableList<ClienteContato>
) : RecyclerView
.Adapter<ContatosClienteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
            p0: ViewGroup,
            p1: Int
    ): ViewHolder {
        return ContatosViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.item_contato_cliente,
                        p0,
                        false
                )
        )
    }
    
    override fun getItemCount(): Int {
        return modelList.size
    }
    
    override fun onBindViewHolder(
            p0: ViewHolder,
            p1: Int
    ) {
        p0.bind(
                modelList[p1],
                context
        )
    }
    
    abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(
                model: ClienteContato,
                context: Context
        )
    }
    
    class ContatosViewHolder(itemView: View) : ViewHolder(itemView) {
        private val nomeTV = itemView.find<TextView>(R.id.tv_nome)
        private val dadosRV = itemView.find<RecyclerView>(R.id.rv_dados_contato)
        
        override fun bind(
                model: ClienteContato,
                context: Context
        ) {
            nomeTV.text = model.nome
            val modelList = createDadoListFromContato(
                    context,
                    model
            )
            dadosRV.adapter = DadoContatoAdapter(
                    context,
                    modelList
            )
            dadosRV.layoutManager = GridLayoutManager(
                    context,
                    context.resources.getInteger(R.integer.dado_cli_grid_span)
            )
        }
        
        private fun createDadoListFromContato(
                context: Context,
                model: ClienteContato
        ): MutableList<DadoContatoAdapter.Model> {
            return ArrayList<DadoContatoAdapter.Model>().apply {
                add(
                        DadoContatoAdapter.Model(
                                context.getString(R.string.dado_contato_telefone_label),
                                createContentString(
                                        context,
                                        model.telefone
                                ),
                                R.drawable.ic_maxima_telefone
                        )
                )
                add(
                        DadoContatoAdapter.Model(
                                context.getString(R.string.dado_contato_email_label),
                                createContentString(
                                        context,
                                        model.email
                                ),
                                R.drawable.ic_maxima_email
                        )
                )
                add(
                        DadoContatoAdapter.Model(
                                context.getString(R.string.dado_contato_celular_label),
                                createContentString(
                                        context,
                                        model.celular
                                ),
                                R.drawable.ic_maxima_telefone
                        )
                )
                add(
                        DadoContatoAdapter.Model(
                                context.getString(R.string.dado_contato_data_nasc_label),
                                createContentString(
                                        context,
                                        model.dataNasc
                                )
                        )
                )
                add(
                        DadoContatoAdapter.Model(
                                context.getString(R.string.dado_contato_conjugue_label),
                                createContentString(
                                        context,
                                        model.conjugue
                                )
                        )
                )
                add(
                        DadoContatoAdapter.Model(
                                context.getString(R.string.dado_contato_data_nasc_conjugue_label),
                                createContentString(
                                        context,
                                        model.dataNascConjugue
                                )
                        )
                )
                add(
                        DadoContatoAdapter.Model(
                                context.getString(R.string.dado_contato_tipo_label),
                                createContentString(
                                        context,
                                        model.tipo
                                )
                        )
                )
                add(
                        DadoContatoAdapter.Model(
                                context.getString(R.string.dado_contato_time_label),
                                createContentString(
                                        context,
                                        model.time
                                )
                        )
                )
            }
        }
        
        private fun createContentString(
                context: Context,
                model: String?
        ) = if (model.isNullOrBlank()) context.getString(R.string.dado_contato_empty) else model
    }
}