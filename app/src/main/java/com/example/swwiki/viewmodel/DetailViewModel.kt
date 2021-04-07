package com.example.swwiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swwiki.model.Favorite
import com.example.swwiki.repository.Repository
import kotlinx.coroutines.launch

class DetailViewModel(val repository: Repository): ViewModel() {


    fun addFavorite(favorite: Favorite){
        viewModelScope.launch {
            var response = repository.addFavorite(favorite)

        }
    }

}
