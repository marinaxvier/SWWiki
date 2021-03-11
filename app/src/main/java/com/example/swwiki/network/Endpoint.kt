package com.example.swwiki.network

import com.example.swwiki.model.Results
import retrofit2.http.GET

interface Endpoint {
    @GET("people/")
    fun getResults() : retrofit2.Call<Results>
}