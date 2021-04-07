package com.example.swwiki.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swwiki.R
import com.example.swwiki.model.Item
import com.example.swwiki.model.PeopleData

class ListAdapter(
    private val context: Context,
    private val itemsList: List<Item>
): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    var onItemClick: ((Item) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view =
                LayoutInflater
                    .from(context)
                    .inflate(R.layout.activity_list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var item = itemsList[position]
        holder.tvName!!.text = item.name
    }

    override fun getItemCount() = itemsList.size


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView? = null
        init {
            tvName = itemView.findViewById(R.id.tvName)
            itemView.setOnClickListener {
                var clickedItem = itemsList[adapterPosition]
                onItemClick?.invoke(clickedItem)
            }

        }

    }

}