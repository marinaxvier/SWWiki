package com.example.swwiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.*
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ListViewModel(val repository: Repository): ViewModel() {

    var peopleResponse: MutableLiveData<Response<PeopleResponse>> = MutableLiveData()
    var planetsResponse: MutableLiveData<Response<PlanetsResponse>> = MutableLiveData()
    var starshipsResponse: MutableLiveData<Response<StarshipsResponse>> = MutableLiveData()
    var filmsResponse: MutableLiveData<Response<FilmsResponse>> = MutableLiveData()
    var vehiclesResponse: MutableLiveData<Response<VehiclesResponse>> = MutableLiveData()
    var speciesResponse: MutableLiveData<Response<SpeciesResponse>> = MutableLiveData()

    fun getData(type: String){
        when(type.toLowerCase()){

            "people" -> getPeople()
            "planets" -> getPlanet()
            "starships" -> getStarships()
            "films" -> getFilms()
            "vehicles" -> getVehicles()
            "species" -> getSpecies()


        }
    }


    fun getPeople(){
        viewModelScope.launch {
            val response: Response<PeopleResponse> = repository.getPeople()
            peopleResponse.value = response
        }
    }


    fun getPlanet(){
        viewModelScope.launch {
            val response: Response<PlanetsResponse> = repository.getPlanet()
            planetsResponse.value = response
        }
    }

    fun getStarships(){
        viewModelScope.launch {
            val response: Response<StarshipsResponse> = repository.getStarships()
            starshipsResponse.value = response
        }
    }

    fun getFilms(){
        viewModelScope.launch {
            val response: Response<FilmsResponse> = repository.getFilms()
            filmsResponse.value = response
        }
    }

    fun getVehicles(){
        viewModelScope.launch {
            val response: Response<VehiclesResponse> = repository.getVehicles()
            vehiclesResponse.value = response
        }
    }

    fun getSpecies(){
        viewModelScope.launch {
            val response: Response<SpeciesResponse> = repository.getSpecies()
            speciesResponse.value = response
        }
    }


}