package com.example.swwiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.SpeciesData
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class SpeciesFragmentViewModel(private val repository: Repository): ViewModel() {

    var speciesDataResponse: MutableLiveData<Response<SpeciesData>> = MutableLiveData()

    fun getSpeciesDetail(id: String){
        viewModelScope.launch {
            val response: Response<SpeciesData> = repository.getSpeciesDetail(id)
            speciesDataResponse.value = response
        }
    }

}
