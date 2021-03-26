package com.example.swwiki.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.swwiki.R
import com.example.swwiki.repository.Repository
import com.example.swwiki.ui.adapter.InitialMenuAdapter
import com.example.swwiki.viewmodel.InitialMenuViewModel
import com.example.swwiki.viewmodel.InitialMenuViewModelFactory
import kotlinx.android.synthetic.main.activity_initial_menu.*

class InitialMenuActivity : AppCompatActivity() {

    private lateinit var viewModel: InitialMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial_menu)

        val repository = Repository()
        val viewModelFactory = InitialMenuViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(InitialMenuViewModel::class.java)
        viewModel.getFirstResponse()
        viewModel.myResponse.observe(this, Observer { firstResponse ->
            if (firstResponse.isSuccessful) {
                Log.d("Response", firstResponse.body().toString())
            } else {
                Log.d("Response", firstResponse.errorBody().toString())
            }
        })
        val listSample: ArrayList<String> = arrayListOf("people", "planets", "starships", "films", "vehicles", "species")
        listConfig(listSample)
    }

    fun listConfig(list: ArrayList<String>){
        var initialAdapter =  InitialMenuAdapter(this, list)

        rvInitialMenuItems.apply {
            adapter = initialAdapter
            layoutManager = GridLayoutManager(this@InitialMenuActivity,2,GridLayoutManager.VERTICAL,false)

        }

        initialAdapter.onItemClick = {urlType ->
            val initialMenuIntent: Intent = Intent(this,ListActivity::class.java)
            initialMenuIntent.putExtra("URL", urlType)
            startActivity(initialMenuIntent)
        }
    }
}
