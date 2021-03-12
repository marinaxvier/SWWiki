package com.example.swwiki.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swwiki.R

class InitialMenuAdapter(
    val context: Context,
    val itemsList: List<String>
): RecyclerView.Adapter<InitialMenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InitialMenuViewHolder {
        val view =
            LayoutInflater
                .from(context)
                .inflate(R.layout.initial_menu_list_item, parent, false)
        return InitialMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: InitialMenuViewHolder, position: Int) {
        var item = itemsList.get(position)

        when(item.toLowerCase()){

            "people" -> {
                holder.ivInitialMenuListItemImage?.setImageResource(R.drawable.ic_people)
                holder.tvInitialMenuListItem?.text = "People"
            }

            "planets" -> {
                holder.ivInitialMenuListItemImage?.setImageResource(R.drawable.ic_planets)
                holder.tvInitialMenuListItem?.text = "Planets"
            }

            "films" -> {
                holder.ivInitialMenuListItemImage?.setImageResource(R.drawable.ic_films)
                holder.tvInitialMenuListItem?.text = "Films"
            }

            "species" -> {
                holder.ivInitialMenuListItemImage?.setImageResource(R.drawable.ic_species)
                holder.tvInitialMenuListItem?.text = "Species"
            }

            "vehicles" -> {
                holder.ivInitialMenuListItemImage?.setImageResource(R.drawable.ic_vehicles)
                holder.tvInitialMenuListItem?.text = "Vehicles"
            }

            "starships" -> {
                holder.ivInitialMenuListItemImage?.setImageResource(R.drawable.ic_starships)
                holder.tvInitialMenuListItem?.text = "Starships"
            }



        }
    }

    override fun getItemCount() = itemsList.size
}

class InitialMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvInitialMenuListItem: TextView? = null
    var ivInitialMenuListItemImage: ImageView? = null

    init {
        tvInitialMenuListItem = itemView.findViewById<TextView>(R.id.tvInitialMenuListItemTitle)
        ivInitialMenuListItemImage = itemView.findViewById<ImageView>(R.id.ivInitialMenuListItemImage)
    }
}