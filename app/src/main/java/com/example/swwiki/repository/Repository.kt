package com.example.swwiki.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.swwiki.model.FirstResponse
import com.example.swwiki.network.Retrofit
import retrofit2.Call
import retrofit2.Response

class Repository {

    val serviceFirstResponse = MutableLiveData<FirstResponse>()

    fun getData(): MutableLiveData<FirstResponse>{

        val retrofitClient = Retrofit
            .getRetrofitInstance()

        val callback = Retrofit.getService().getResults()

        callback.enqueue(object : retrofit2.Callback<FirstResponse> {
            override fun onResponse(call: Call<FirstResponse>, response: Response<FirstResponse>) {
                val results: FirstResponse? = response.body()
                serviceFirstResponse.value = results
            }

            override fun onFailure(call: Call<FirstResponse>, t: Throwable) {
                Log.i("Callback", "onFailure: Falha")
            }

        })

        return serviceFirstResponse

    }
}