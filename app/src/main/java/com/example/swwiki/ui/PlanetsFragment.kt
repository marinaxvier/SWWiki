package com.example.swwiki.ui


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.R
import com.example.swwiki.model.PlanetData
import com.example.swwiki.repository.Repository
import com.example.swwiki.viewmodel.PlanetsFragmentViewModel
import com.example.swwiki.viewmodel.PlanetsFragmentViewModelFactory
import kotlinx.android.synthetic.main.fragment_planets.*

class PlanetsFragment(val id: String) : Fragment(R.layout.fragment_planets) {

    private lateinit var viewModel: PlanetsFragmentViewModel
    private var planetDataResult: PlanetData? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = Repository()
        val viewModelFactory = PlanetsFragmentViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PlanetsFragmentViewModel::class.java)
        viewModel.getPlanetDetail(id)
        viewModel.planetDataResponse.observe(this, Observer { planetDataResponse ->
            if(planetDataResponse.isSuccessful){
                planetDataResult = planetDataResponse.body()
            }
            planetDataResult?.let { detailConfig(it) }
        })
    }


    fun detailConfig(planetData: PlanetData){
        tvRotationPeriod.text = planetData.rotationPeriod
        tvOrbitalPeriod.text = planetData.orbitalPeriod
        tvDiameter.text = planetData.diameter
        tvClimate.text = planetData.climate
        tvGravity.text = planetData.climate
        tvTerrain.text = planetData.terrain
        tvSurfaceWater.text = planetData.surfaceWater
        tvPopulation.text = planetData.population
    }
}