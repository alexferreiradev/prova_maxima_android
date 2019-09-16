package dev.alexferreira.ui.adapter

import android.content.Context
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dev.alexferreira.R
import dev.alexferreira.data.model.CriticaPedido
import dev.alexferreira.data.model.PedidoCliente
import dev.alexferreira.helper.DateHelper
import org.jetbrains.anko.find
import timber.log.Timber
import java.text.DateFormat
import java.util.*

class PedidoClienteListAdapter(var modelList: List<PedidoCliente>, var context: Context) :
    RecyclerView.Adapter<PedidoClienteListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_historico_pedido, p0, false))
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(modelList[p1], context)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var numeroPedido = itemView.find<TextView>(R.id.tv_numero_pedido)
        var cliente = itemView.find<TextView>(R.id.tv_cliente_pedido)
        var horaPedido = itemView.find<TextView>(R.id.tv_hora_pedido)
        var statusPedido = itemView.find<TextView>(R.id.tv_status_pedido)
        var criticaPedidoIV = itemView.find<ImageView>(R.id.iv_critica_pedido)
        var criticaPedidoLabel = itemView.find<TextView>(R.id.tv_critica_pedido_label)
        var valorPedido = itemView.find<TextView>(R.id.tv_valor_pedido)

        fun bind(
            pedidoCliente: PedidoCliente,
            contextParam: Context
        ) {
            numeroPedido.text = String.format("%s/%s", pedidoCliente.numeroPedRca, pedidoCliente.numeroPedERP)
            cliente.text = String.format("%s - %s", pedidoCliente.codigoCliente, pedidoCliente.nomeCliente)
            statusPedido.text = pedidoCliente.status?.description
            valorPedido.text = contextParam.getString(R.string.valor_pedido_default)
            configDataPedido(pedidoCliente, contextParam)
            configCriticaPedido(pedidoCliente, contextParam)
        }

        private fun configCriticaPedido(
            pedidoCliente: PedidoCliente,
            contextParam: Context
        ) {
            val critica = pedidoCliente.critica
            if (critica != null) {
                @Suppress("REDUNDANT_ELSE_IN_WHEN") // No futuro pode ter casos novos e esquecer
                when (critica) {
                    CriticaPedido.FALHA_PARCIAL -> {
                        criticaPedidoIV.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                contextParam.resources,
                                R.drawable.ic_maxima_critica_alerta,
                                null
                            )
                        )
                    }
                    CriticaPedido.SUCESSO -> {
                        criticaPedidoIV.setImageDrawable(
                            ResourcesCompat.getDrawable(
                                contextParam.resources,
                                R.drawable.ic_maxima_critica_sucesso,
                                null
                            )
                        )
                    }
                    else -> {
                        Timber.e("Critica de pedido não reconhecida: $critica")
                    }
                }
                criticaPedidoIV.visibility = View.VISIBLE
                criticaPedidoLabel.visibility = View.VISIBLE
            } else {
                criticaPedidoIV.visibility = View.GONE
                criticaPedidoLabel.visibility = View.GONE
            }
        }

        private fun configDataPedido(
            pedidoCliente: PedidoCliente,
            contextParam: Context
        ) {
            val pedidoDate = DateHelper.parseString(PedidoCliente.DATE_PATTERN, pedidoCliente.data)
            if (pedidoDate != null) {
                val calendar = Calendar.getInstance()
                calendar.roll(Calendar.DAY_OF_MONTH, 1)
                if (pedidoDate.time < calendar.time.time) {
                    horaPedido.text = DateFormat.getTimeInstance(DateFormat.SHORT).format(pedidoDate)
                } else {
                    horaPedido.text = DateFormat.getDateInstance(DateFormat.SHORT).format(pedidoDate)
                }
            } else {
                horaPedido.text = contextParam.getString(R.string.empty_pedido_date)
            }
        }
    }

}
