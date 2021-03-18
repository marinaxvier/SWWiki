package com.example.swwiki.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.R
import com.example.swwiki.model.PeopleResponse
import com.example.swwiki.repository.Repository
import com.example.swwiki.viewmodel.ListViewModel
import com.example.swwiki.viewmodel.ListViewModelFactory

class ItemListClickedActivity : AppCompatActivity() {

    private lateinit var viewModel: ListViewModel
    private lateinit var peopleList: PeopleResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list_clicked)

        val repository = Repository()
        val viewModelFactory = ListViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(ListViewModel::class.java)

        val type: String = intent.extras?.get("URL") as String
        if (type != null){
            viewModel.getData(type)
        }

        viewModel.peopleResponse.observe(this, Observer { peopleResponse ->
            if (peopleResponse.isSuccessful) {
                peopleList = peopleResponse.body()!!
                Log.i("Retorno", "${peopleList.results[0].name.toString()}")
            }
        })

    }
}