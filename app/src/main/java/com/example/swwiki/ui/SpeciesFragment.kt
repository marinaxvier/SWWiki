package com.example.swwiki.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.R
import com.example.swwiki.model.SpeciesData
import com.example.swwiki.repository.Repository
import com.example.swwiki.viewmodel.SpeciesFragmentViewModel
import com.example.swwiki.viewmodel.SpeciesFragmentViewModelFactory
import kotlinx.android.synthetic.main.activity_list_item.*
import kotlinx.android.synthetic.main.fragment_species.*


class SpeciesFragment(val id: String) : Fragment(R.layout.fragment_species) {
    private lateinit var viewModel: SpeciesFragmentViewModel
    private var speciesDataResult: SpeciesData? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = Repository()
        val viewModelFactory = SpeciesFragmentViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(SpeciesFragmentViewModel::class.java)
        viewModel.getSpeciesDetail(id)
        viewModel.speciesDataResponse.observe(this, Observer { speciesDataResponse ->
            if (speciesDataResponse.isSuccessful){
                speciesDataResult = speciesDataResponse.body()
            }
            detailConfig(speciesDataResult!!)
        })





    }

    fun detailConfig(speciesData: SpeciesData){
        tvClassification.text = speciesData.classification
        tvDesignation.text = speciesData.designation
        tvAverageHeight.text = speciesData.averageHeight
        tvSkinColors.text = speciesData.skinColors
        tvHairColors.text = speciesData.hairColors
        tvEyeColors.text = speciesData.eyeColors
        tvAverageLifespan.text = speciesData.averageLifeSpan
        tvLanguage.text = speciesData.language
    }
}