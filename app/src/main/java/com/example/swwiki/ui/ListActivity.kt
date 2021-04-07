package com.example.swwiki.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swwiki.R
import com.example.swwiki.model.*
import com.example.swwiki.repository.Repository
import com.example.swwiki.ui.adapter.ListAdapter
import com.example.swwiki.viewmodel.ListViewModel
import com.example.swwiki.viewmodel.ListViewModelFactory
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.initial_menu_list_item.*

class ListActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel

    //Objetos primeira chamada API
    private lateinit var peopleList: PeopleResponse
    private lateinit var planetsList: PlanetsResponse
    private lateinit var starshipsList: StarshipsResponse
    private lateinit var filmsList: FilmsResponse
    private lateinit var vehiclesList: VehiclesResponse
    private lateinit var speciesList: SpeciesResponse

    //Listas
    private lateinit var peopleDataResultList: List<PeopleData>
    private lateinit var planetDataResultList: List<PlanetData>
    private lateinit var starshipsDataResultList: List<StarshipsData>
    private lateinit var filmsDataResultList: List<FilmsData>
    private lateinit var vehiclesDataResultList: List<VehiclesData>
    private lateinit var speciesDataResultList: List<SpeciesData>
    private var itemList: ArrayList<Item> = arrayListOf()
    var type: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val repository = Repository()
        val viewModelFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(ListViewModel::class.java)

        type = intent.extras?.get("URL") as String

        if (type != null){
            viewModel.getData(type)
        }

        observersManagement()

    }

    private fun observersManagement() {

        viewModel.peopleResponse.observe(this, Observer { peopleResponse ->
            if (peopleResponse.isSuccessful) {
                peopleList = peopleResponse.body()!!
                peopleDataResultList = peopleList.results
                for (people in peopleDataResultList) {
                    itemList.add(Item(people.name, people.url))
                }
                listConfig(itemList)
            }
        })

        viewModel.planetsResponse.observe(this, Observer { planetsResponse ->
            if (planetsResponse.isSuccessful) {
                planetsList = planetsResponse.body()!!
                planetDataResultList = planetsList.results
                for (planet in planetDataResultList) {
                    itemList.add(Item(planet.name, planet.url))
                }
                listConfig(itemList)
            }
        })

        viewModel.starshipsResponse.observe(this, Observer { starshipsResponse ->
            if (starshipsResponse.isSuccessful) {
                starshipsList = starshipsResponse.body()!!
                starshipsDataResultList = starshipsList.results
                for (starship in starshipsDataResultList) {
                    itemList.add(Item(starship.name, starship.url))
                }
                listConfig(itemList)
            }
        })

        viewModel.filmsResponse.observe(this, Observer { filmsResponse ->
            if (filmsResponse.isSuccessful) {
                filmsList = filmsResponse.body()!!
                filmsDataResultList = filmsList.results
                for (film in filmsDataResultList) {
                    itemList.add(Item(film.title, film.url))
                }
                listConfig(itemList)
            }
        })

        viewModel.speciesResponse.observe(this, Observer { speciesResponse ->
            if (speciesResponse.isSuccessful) {
                speciesList = speciesResponse.body()!!
                speciesDataResultList = speciesList.results
                for (specie in speciesDataResultList) {
                    itemList.add(Item(specie.name, specie.url))
                }
                listConfig(itemList)
            }
        })

        viewModel.vehiclesResponse.observe(this, Observer { vehiclesResponse ->
            if (vehiclesResponse.isSuccessful) {
                vehiclesList = vehiclesResponse.body()!!
                vehiclesDataResultList = vehiclesList.results
                for (vehicle in vehiclesDataResultList) {
                    itemList.add(Item(vehicle.name, vehicle.url))
                }
                listConfig(itemList)
            }
        })



    }

    fun listConfig(list: List<Item>){
        var listAdapter = ListAdapter(this, list)

        rvList.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@ListActivity)
        }

        listAdapter.onItemClick = {clickedItem ->
            val detailIntent: Intent = Intent(this,DetailActivity::class.java)
            detailIntent.putExtra("ITEM", clickedItem)
            detailIntent.putExtra("TYPE", type)
            startActivity(detailIntent)
        }

    }


}