package com.example.swwiki.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.swwiki.model.FirstResponse
import com.example.swwiki.repository.Repository

class InitialMenuViewModel: ViewModel() {
    var fistResponseLiveData: MutableLiveData<FirstResponse>? = null

    fun getFirstResponse() : LiveData<FirstResponse>?{
        fistResponseLiveData = Repository().getData()
        return fistResponseLiveData

    }
}