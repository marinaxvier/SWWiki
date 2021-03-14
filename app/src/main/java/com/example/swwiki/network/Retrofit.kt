package com.example.swwiki.network

import com.example.swwiki.api.Api
import com.example.swwiki.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    private val retrofit by lazy{
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }


    val api: Api by lazy {
        retrofit.create(Api::class.java)
    }

}