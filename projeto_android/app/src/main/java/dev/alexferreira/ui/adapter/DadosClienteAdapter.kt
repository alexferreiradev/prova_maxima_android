package dev.alexferreira.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import dev.alexferreira.R
import org.jetbrains.anko.find

class DadosClienteAdapter(
        val context: Context,
        private val modelList: MutableList<Model>
) : RecyclerView
.Adapter<DadosClienteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
            p0: ViewGroup,
            p1: Int
    ): ViewHolder {
        return ClienteViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.item_dado_cliente,
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
        p0.bind(modelList[p1])
    }
    
    abstract inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(model: Model)
    }
    
    inner class ClienteViewHolder(itemView: View) : ViewHolder(itemView) {
        private val labelTV = itemView.find<TextView>(R.id.tv_label)
        private val contentTV = itemView.find<TextView>(R.id.tv_content)
        
        override fun bind(model: Model) {
            labelTV.text = model.label
            contentTV.text = model.content
        }
    }
    
    class Model(
            val label: String,
            val content: String
    )
}