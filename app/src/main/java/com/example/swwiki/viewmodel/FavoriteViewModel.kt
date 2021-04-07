package com.example.swwiki.viewmodel

import androidx.lifecycle.*
import com.example.swwiki.model.Favorite
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch

class FavoriteViewModel(val repository: Repository) : ViewModel() {
    var favoriteResponse: MutableLiveData<List<Favorite>> = MutableLiveData()


    fun getAllFavorites(){
        viewModelScope.launch {
            var response = repository.getAllFavorites()
            favoriteResponse.value = response
        }
    }

}