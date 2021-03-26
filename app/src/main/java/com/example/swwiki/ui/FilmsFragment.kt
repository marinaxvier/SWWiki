package com.example.swwiki.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.R
import com.example.swwiki.model.FilmsData
import com.example.swwiki.repository.Repository
import com.example.swwiki.viewmodel.*
import kotlinx.android.synthetic.main.fragment_films.*

class FilmsFragment(val id: String) : Fragment(R.layout.fragment_films) {

    private lateinit var viewModel: FilmsFragmentViewModel
    private var filmsDataResult: FilmsData? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = Repository()
        val viewModelFactory = FilmsFragmentViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FilmsFragmentViewModel::class.java)
        viewModel.getFilmsDetail(id)
        viewModel.filmsDataResponse.observe(this, Observer { filmsDataResponse ->
            if (filmsDataResponse.isSuccessful){
                filmsDataResult = filmsDataResponse.body()
            }
            detailConfig(filmsDataResult!!)
        })
    }

    fun detailConfig(filmsData: FilmsData){
        tvFilmEpisode.text = "Episode ${filmsData.episodeNumber}"
        tvOpeningCrawl.text = filmsData.openingCrawl
        tvFilmDirector.text = filmsData.director
        tvFilmProducer.text = filmsData.producer
        tvFilmReleaseDate.text = filmsData.releaseDate
    }
}