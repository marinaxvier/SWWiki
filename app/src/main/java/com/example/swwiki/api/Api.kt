package com.example.swwiki.api

import com.example.swwiki.model.FirstResponse
import com.example.swwiki.model.PeopleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    //Busca lista de itens de menu
    @GET(" ")
    suspend fun getFirstResponse(): Response<FirstResponse>
    //Busca lista de pessoas
    @GET("people/")
    suspend fun getPeople(): Response<PeopleResponse>
    //Busca pessoa específica
    @GET("people/{id}")
    fun getPeople(@Path("id") id : String): Response<PeopleResponse>
}