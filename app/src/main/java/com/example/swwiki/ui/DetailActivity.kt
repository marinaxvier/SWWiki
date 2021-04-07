package com.example.swwiki.ui

import VehiclesFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.R
import com.example.swwiki.database.FavoriteDatabase
import com.example.swwiki.model.Favorite
import com.example.swwiki.model.Item
import com.example.swwiki.repository.Repository
import com.example.swwiki.viewmodel.DetailViewModel
import com.example.swwiki.viewmodel.DetailViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val item: Item = intent.extras?.get("ITEM") as Item
        val type: String = intent.extras?.get("TYPE") as String
        val id: String = item.getItemId(item.url)

        var favoriteDAO = FavoriteDatabase.getDatabase(this).favoriteDao()
        var repository = Repository(favoriteDAO)

        tvDetailName.text = item.name

        val peopleFragment = PeopleFragment(id)
        val planetsFragment = PlanetsFragment(id)
        val starshipsFragment = StarshipsFragment(id)
        val filmsFragment = FilmsFragment(id)
        val vehiclesFragment = VehiclesFragment(id)
        val speciesFragment = SpeciesFragment(id)

        val viewModelFactory = DetailViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        when (type){
            "people" -> supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flItemFragment, peopleFragment)
                            commit()
            }

            "planets" -> supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flItemFragment, planetsFragment)
                            commit()
            }

            "starships" -> supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flItemFragment, starshipsFragment)
                            commit()
            }

            "films" -> supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flItemFragment, filmsFragment)
                            commit()
            }

            "vehicles" -> supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flItemFragment, vehiclesFragment)
                            commit()
            }

            "species" -> supportFragmentManager.beginTransaction().apply {
                            replace(R.id.flItemFragment, speciesFragment)
                            commit()
            }

        }

        ivFavorite.setOnClickListener{
            val favorite = Favorite(id,item.name, item.url, type)
            viewModel.addFavorite(favorite)
            ivFavorite.setImageResource(R.drawable.ic_star)
        }


    }
}