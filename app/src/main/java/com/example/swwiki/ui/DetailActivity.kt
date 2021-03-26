package com.example.swwiki.ui

import VehiclesFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swwiki.R
import com.example.swwiki.model.Item
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val item: Item = intent.extras?.get("ITEM") as Item
        val type: String = intent.extras?.get("TYPE") as String
        val id: String = item.getItemId(item.url)

        tvDetailName.text = item.name

        val peopleFragment = PeopleFragment(id)
        val planetsFragment = PlanetsFragment(id)
        val starshipsFragment = StarshipsFragment(id)
        val filmsFragment = FilmsFragment(id)
        val vehiclesFragment = VehiclesFragment(id)
        val speciesFragment = SpeciesFragment(id)

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


    }
}