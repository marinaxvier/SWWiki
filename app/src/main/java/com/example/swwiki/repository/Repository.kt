package com.example.swwiki.repository

import androidx.lifecycle.MutableLiveData
import com.example.swwiki.model.FirstResponse
import com.example.swwiki.network.Retrofit
import retrofit2.Response

class Repository {

    suspend fun getData(): Response<FirstResponse> {
        return Retrofit.api.getFirstResponse()
    }

}
