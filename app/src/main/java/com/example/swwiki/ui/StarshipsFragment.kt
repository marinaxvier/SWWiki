package com.example.swwiki.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.R
import com.example.swwiki.repository.Repository
import com.example.swwiki.model.StarshipsData
import com.example.swwiki.viewmodel.StarshipsFragmentViewModel
import com.example.swwiki.viewmodel.StarshipsFragmentViewModelFactory
import kotlinx.android.synthetic.main.fragment_starships_and_vehicles.*


class StarshipsFragment(val id: String) : Fragment(R.layout.fragment_starships_and_vehicles) {

    private lateinit var viewModel: StarshipsFragmentViewModel
    private var starshipsDataResult: StarshipsData? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = Repository()
        val viewModelFactory = StarshipsFragmentViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(StarshipsFragmentViewModel::class.java)
        viewModel.getStarshipsDetail(id)
        viewModel.starshipsDataResponse.observe(this, Observer { starshipsDataResponse ->
            if (starshipsDataResponse.isSuccessful){
                starshipsDataResult = starshipsDataResponse.body()
            }
            detailConfig(starshipsDataResult!!)
        })
    }

    fun detailConfig(starshipsData: StarshipsData){
        tvModel.text = starshipsData.model
        tvLength.text = starshipsData.length
        tvPassengers.text = starshipsData.passengers
        tvMaxAtmospheringSpeed.text = starshipsData.maxAtmospheringSpeed
        tvCargoCapacity.text = starshipsData.cargoCapacity
    }
}