package com.example.swwiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.PeopleResponse
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ListViewModel(val repository: Repository): ViewModel() {

    var peopleResponse: MutableLiveData<Response<PeopleResponse>> = MutableLiveData()

    fun getData(type: String){
        when(type.toLowerCase()){

            "people" -> getPeople()

        }
    }


    fun getPeople(){
        viewModelScope.launch {
            val response: Response<PeopleResponse> = repository.getPeople()
            peopleResponse.value = response
        }
    }
}