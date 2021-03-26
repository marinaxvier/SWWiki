package com.example.swwiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.FilmsData
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class FilmsFragmentViewModel(private val repository: Repository): ViewModel() {
    var filmsDataResponse: MutableLiveData<Response<FilmsData>> = MutableLiveData()

    fun getFilmsDetail(id: String){
        viewModelScope.launch {
            val response: Response<FilmsData> = repository.getFilmsDetail(id)
            filmsDataResponse.value = response
        }
    }

}
