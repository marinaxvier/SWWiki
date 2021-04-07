package com.example.swwiki.utils

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.swwiki.ui.adapter.FavoriteListAdapter

class SwipeToDelete (var adapter: FavoriteListAdapter): ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        var pos: Int = viewHolder.adapterPosition
        adapter.deleteItem(pos)
    }

}