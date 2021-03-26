package com.example.swwiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.StarshipsData
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class StarshipsFragmentViewModel(private val repository: Repository): ViewModel() {

    var starshipsDataResponse: MutableLiveData<Response<StarshipsData>> = MutableLiveData()

    fun getStarshipsDetail(id: String){
        viewModelScope.launch {
            val response: Response<StarshipsData> = repository.getStarshipsDetail(id)
            starshipsDataResponse.value = response
        }
    }

}
