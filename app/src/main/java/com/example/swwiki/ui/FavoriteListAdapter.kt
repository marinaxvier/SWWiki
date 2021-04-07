package com.example.swwiki.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swwiki.R
import com.example.swwiki.model.Favorite

class FavoriteListAdapter(
    private val context: Context,
    private val list: List<Favorite>
): RecyclerView.Adapter<FavoriteListAdapter.FavoriteViewHolder>() {

    var onItemClick: ((Favorite) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view =
            LayoutInflater
                .from(context)
                .inflate(R.layout.activity_list_item, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        var item = list[position]
        holder.tvName?.text = item.name
    }

    override fun getItemCount() = list.size

    inner class FavoriteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var tvName: TextView? = null

        init {
            tvName = itemView.findViewById(R.id.tvName)
            itemView.setOnClickListener {
                var clickedItem = list[adapterPosition]
                onItemClick?.invoke(clickedItem)
            }
        }

    }
}
