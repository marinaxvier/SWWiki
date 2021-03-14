package com.example.swwiki.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.R
import com.example.swwiki.repository.Repository
import com.example.swwiki.viewmodel.InitialMenuViewModel
import com.example.swwiki.viewmodel.InitialMenuViewModelFactory

class InitialMenuActivity : AppCompatActivity() {

    private lateinit var viewModel: InitialMenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial_menu)

        val repository = Repository()
        val viewModelFactory = InitialMenuViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(InitialMenuViewModel::class.java)
        viewModel.getFirstResponse()
        viewModel.myResponse.observe(this, Observer { FirstResponse ->
            if (FirstResponse.isSuccessful) {
                Log.d("Response", FirstResponse.body().toString())
            } else {
                Log.d("Response", FirstResponse.errorBody().toString())
            }
        })

    }

}
