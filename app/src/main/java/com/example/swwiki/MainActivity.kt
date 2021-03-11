package com.example.swwiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.swwiki.network.Endpoint
import com.example.swwiki.network.Retrofit
import com.example.swwiki.model.Results
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData(){
        val retrofitClient = Retrofit
                .getRetrofitInstance()
        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getResults()

        callback.enqueue(object : retrofit2.Callback<Results>{
            override fun onResponse(call: Call<Results>, response: Response<Results>) {
                val results: Results? = response.body()
                tvResult.text = results?.results?.get(0)?.name.toString()
            }

            override fun onFailure(call: Call<Results>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })

    }
}
