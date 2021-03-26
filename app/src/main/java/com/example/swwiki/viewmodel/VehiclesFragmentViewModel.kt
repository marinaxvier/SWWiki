package com.example.swwiki.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.VehiclesData
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class VehiclesFragmentViewModel(private val repository: Repository): ViewModel() {
    var vehiclesDataResponse: MutableLiveData<Response<VehiclesData>> = MutableLiveData()

    fun getVehiclesDetail(id: String){
        viewModelScope.launch {
            val response: Response<VehiclesData> = repository.getVehiclesDetail(id)
            vehiclesDataResponse.value = response
        }
    }

}
