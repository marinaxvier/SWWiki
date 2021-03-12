package com.example.swwiki.network

import com.example.swwiki.model.FirstResponse
import com.example.swwiki.model.People
import retrofit2.http.GET
import retrofit2.http.Path

interface ISWService {
    //Busca lista de itens de menu
    @GET(" ")
    fun getResults(): retrofit2.Call<FirstResponse>
    //Busca lista de pessoas
    @GET("people/")
    fun getPeople(): retrofit2.Call<People>
    //Busca pessoa específica
    @GET("people/{id}")
    fun getPeople(@Path("id") id : String): retrofit2.Call<People>
}