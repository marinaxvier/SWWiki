package com.example.swwiki.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.R
import com.example.swwiki.model.PeopleData
import com.example.swwiki.repository.Repository
import com.example.swwiki.viewmodel.PeopleFragmentViewModel
import com.example.swwiki.viewmodel.PeopleFragmentViewModelFactory
import kotlinx.android.synthetic.main.fragment_people.*
import kotlinx.android.synthetic.main.fragment_planets.*

class PeopleFragment(val id: String) : Fragment(R.layout.fragment_people) {

    private lateinit var viewModel: PeopleFragmentViewModel
    private var peopleDataResult: PeopleData? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = Repository()
        val viewModelFactory = PeopleFragmentViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(PeopleFragmentViewModel::class.java)
        viewModel.getPeopleDetail(id)
        viewModel.peopleDataResponse.observe(this, Observer { peopleDataResponse ->
            if (peopleDataResponse.isSuccessful){
                peopleDataResult = peopleDataResponse.body()
            }
            detailConfig(peopleDataResult!!)
        })





    }

    fun detailConfig(peopleData: PeopleData){
        tvHeight.text = peopleData.height
        tvMass.text = peopleData.mass
        tvHairColor.text = peopleData.hairColor
        tvSkinColor.text = peopleData.skinColor
        tvEyeColor.text = peopleData.eyeColor
        tvBirthYear.text = peopleData.birthYear
        tvGender.text = peopleData.gender
    }



}