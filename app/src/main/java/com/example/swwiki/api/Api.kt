package com.example.swwiki.api

import com.example.swwiki.model.*
import com.example.swwiki.model.FilmsResponse
import com.example.swwiki.model.FilmsData
import com.example.swwiki.model.StarshipsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    //Busca lista de itens de menu
    @GET(" ")
    suspend fun getFirstResponse(): Response<FirstResponse>

    //PEOPLE
    @GET("people/")
    suspend fun getPeople(): Response<PeopleResponse>

    @GET("people/{id}/")
    suspend fun getPeopleDetail(@Path("id") id: String): Response<PeopleData>

    //PLANETS
    @GET("planets/")
    suspend fun getPlanets(): Response<PlanetsResponse>

    @GET("planets/{id}/")
    suspend fun getPlanetDetail(@Path("id") id: String): Response<PlanetData>

    //STARSHIPS
    @GET("starships/")
    suspend fun getStarships(): Response<StarshipsResponse>

    @GET("starships/{id}/")
    suspend fun getStarshipsDetail(@Path("id") id: String): Response<StarshipsData>

    //FILMS
    @GET("films/")
    suspend fun getFilms(): Response<FilmsResponse>

    @GET("films/{id}/")
    suspend fun getFilmsDetail(@Path("id") id: String): Response<FilmsData>

    //VEHICLES
    @GET("vehicles/")
    suspend fun getVehicles(): Response<VehiclesResponse>

    @GET("vehicles/{id}/")
    suspend fun getVehiclesDetail(@Path("id") id: String): Response<VehiclesData>

    //SPECIES
    @GET("species/")
    suspend fun getSpecies(): Response<SpeciesResponse>

    @GET("species/{id}/")
    suspend fun getSpeciesDetail(@Path("id") id: String): Response<SpeciesData>

}