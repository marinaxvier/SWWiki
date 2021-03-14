package com.example.swwiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.FirstResponse
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class InitialMenuViewModel(val repository: Repository): ViewModel() {
    var myResponse: MutableLiveData<Response<FirstResponse>> = MutableLiveData()

    fun getFirstResponse() {
        viewModelScope.launch {
            val response: Response<FirstResponse> = repository.getData()
            myResponse.value = response
        }
    }
}