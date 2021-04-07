package com.example.swwiki.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swwiki.R
import com.example.swwiki.database.FavoriteDatabase
import com.example.swwiki.model.Favorite
import com.example.swwiki.model.Item
import com.example.swwiki.repository.Repository
import com.example.swwiki.viewmodel.FavoriteViewModel
import com.example.swwiki.viewmodel.FavoriteViewModelFactory
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : AppCompatActivity() {
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var favorites: List<Favorite>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        var favoriteDAO = FavoriteDatabase.getDatabase(this).favoriteDao()
        var repository = Repository(favoriteDAO)
        val viewModelFactory = FavoriteViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FavoriteViewModel::class.java)

        viewModel.getAllFavorites()

        viewModel.favoriteResponse.observe(this, Observer { favoriteResponse ->
            if (!favoriteResponse.isNullOrEmpty()){
                favorites = favoriteResponse

                adapterConfig()
            }
        })



    }

    private fun adapterConfig() {
        var listAdapter = FavoriteListAdapter(this, favorites)

        rvFavorite.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
        }

        listAdapter.onItemClick = {clickedItem ->
            val detailIntent: Intent = Intent(this,DetailActivity::class.java)
            detailIntent.putExtra("ITEM", Item(clickedItem.name,clickedItem.url))
            detailIntent.putExtra("TYPE", clickedItem.type)
            startActivity(detailIntent)
        }

    }


}