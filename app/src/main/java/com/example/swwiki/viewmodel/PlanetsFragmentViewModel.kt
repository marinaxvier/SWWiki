package com.example.swwiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.PlanetData
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class PlanetsFragmentViewModel(private val repository: Repository): ViewModel() {
    var planetDataResponse: MutableLiveData<Response<PlanetData>> = MutableLiveData()

    fun getPlanetDetail(id: String){
        viewModelScope.launch {
            val response: Response<PlanetData> = repository.getPlanetDetail(id)
            planetDataResponse.value = response
        }
    }
}