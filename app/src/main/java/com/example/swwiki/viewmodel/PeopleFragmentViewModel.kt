package com.example.swwiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.PeopleData
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class PeopleFragmentViewModel(private val repository: Repository): ViewModel() {

    var peopleDataResponse: MutableLiveData<Response<PeopleData>> = MutableLiveData()

    fun getPeopleDetail(id: String){
        viewModelScope.launch {
            val response: Response<PeopleData> = repository.getPeopleDetail(id)
            peopleDataResponse.value = response
        }
    }

}
