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
import org.jetbrains.anko.find

class DadoContatoAdapter(
        private val context: Context,
        private val modelList: MutableList<Model>
) : RecyclerView
.Adapter<DadoContatoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
            p0: ViewGroup,
            p1: Int
    ): ViewHolder {
        return ContatosViewHolder(
                LayoutInflater.from(context).inflate(
                        R.layout.item_dado_contato,
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
                model: Model,
                context: Context
        )
    }
    
    class ContatosViewHolder(itemView: View) : ViewHolder(itemView) {
        private val labelTV = itemView.find<TextView>(R.id.tv_label)
        private val dataTV = itemView.find<TextView>(R.id.tv_data)
        private val iconIV = itemView.find<ImageView>(R.id.iv_icon_contato)
        
        override fun bind(
                model: Model,
                context: Context
        ) {
            labelTV.text = model.label
            dataTV.text = model.content
            model.iconRes?.let {
                iconIV
                        .setImageDrawable(
                                ResourcesCompat.getDrawable(
                                        context.resources,
                                        it,
                                        null
                                )
                        )
            }
        }
    }
    
    class Model(
            val label: String,
            val content: String,
            val iconRes: Int? = null
    )
}