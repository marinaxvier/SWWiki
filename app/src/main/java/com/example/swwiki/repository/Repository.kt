package com.example.swwiki.repository

import com.example.swwiki.model.SpeciesData
import com.example.swwiki.model.SpeciesResponse
import com.example.swwiki.model.VehiclesData
import com.example.swwiki.model.VehiclesResponse
import com.example.swwiki.model.*
import com.example.swwiki.network.Retrofit
import com.example.swwiki.model.FilmsData
import com.example.swwiki.model.StarshipsData
import retrofit2.Response

class Repository {

    suspend fun getData(): Response<FirstResponse> {
        return Retrofit.api.getFirstResponse()
    }
    //PEOPLE
    suspend fun getPeople(): Response<PeopleResponse> {
        return Retrofit.api.getPeople()
    }

    suspend fun getPeopleDetail(id: String): Response<PeopleData> {
        return Retrofit.api.getPeopleDetail(id)
    }
    //PLANET
    suspend fun  getPlanet(): Response<PlanetsResponse>{
        return Retrofit.api.getPlanets()
    }

    suspend fun getPlanetDetail(id: String): Response<PlanetData> {
        return Retrofit.api.getPlanetDetail(id)

    }
    //STARSHIPS
    suspend fun getStarships(): Response<StarshipsResponse> {
        return Retrofit.api.getStarships()
    }

    suspend fun getStarshipsDetail(id: String): Response<StarshipsData> {
        return Retrofit.api.getStarshipsDetail(id)
    }

    //FILMS
    suspend fun getFilms(): Response<FilmsResponse> {
        return Retrofit.api.getFilms()
    }

    suspend fun getFilmsDetail(id: String): Response<FilmsData> {
        return Retrofit.api.getFilmsDetail(id)
    }

    //VEHICLES
    suspend fun getVehicles(): Response<VehiclesResponse> {
        return Retrofit.api.getVehicles()
    }

    suspend fun getVehiclesDetail(id: String): Response<VehiclesData> {
        return Retrofit.api.getVehiclesDetail(id)
    }

    //SPECIES
    suspend fun getSpecies(): Response<SpeciesResponse> {
        return Retrofit.api.getSpecies()
    }

    suspend fun getSpeciesDetail(id: String): Response<SpeciesData> {
        return Retrofit.api.getSpeciesDetail(id)
    }

}
