package dev.alexferreira.ui.adapter

import android.content.Context
import android.content.res.Resources
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dev.alexferreira.R
import dev.alexferreira.ui.model.MainMenuModel
import org.jetbrains.anko.find

class MainMenuAdapter(
    private val context: Context,
    private val menuList: MutableList<MainMenuModel>,
    private val listener: Listener
) : RecyclerView.Adapter<MainMenuAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_menu, p0, false))
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
        viewHolder.bind(menuList[pos], listener, context.resources)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.find<ImageView>(R.id.iv_menu)
        private val titleTV = itemView.find<TextView>(R.id.tv_menu_title)

        fun bind(
            mainMenuModel: MainMenuModel,
            listener: Listener,
            resources: Resources
        ) {
            image.setImageDrawable(ResourcesCompat.getDrawable(resources, mainMenuModel.image, null))
            titleTV.text = mainMenuModel.title
            itemView.setOnClickListener {
                listener.onMenuItemClick(mainMenuModel)
            }
        }
    }

    interface Listener {
        fun onMenuItemClick(mainMenuModel: MainMenuModel)
    }
}