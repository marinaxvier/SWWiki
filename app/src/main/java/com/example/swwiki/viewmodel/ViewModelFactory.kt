package com.example.swwiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.swwiki.repository.Repository

class InitialMenuViewModelFactory(
    private val repository: Repository
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InitialMenuViewModel(repository) as T
    }
}

class ListViewModelFactory(
    private val repository: Repository
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}

class PeopleFragmentViewModelFactory(
    private val repository: Repository
    ): ViewModelProvider.Factory{
    override  fun <T:ViewModel?> create(modelClass: Class<T>): T{
        return PeopleFragmentViewModel(repository) as T
    }
}

class PlanetsFragmentViewModelFactory(
    private val repository: Repository
    ): ViewModelProvider.Factory{
    override  fun <T:ViewModel?> create(modelClass: Class<T>): T{
        return PlanetsFragmentViewModel(repository) as T
    }
}

class StarshipsFragmentViewModelFactory(
    private val repository: Repository
): ViewModelProvider.Factory{
    override  fun <T:ViewModel?> create(modelClass: Class<T>): T{
        return StarshipsFragmentViewModel(repository) as T
    }
}

class FilmsFragmentViewModelFactory(
    private val repository: Repository
): ViewModelProvider.Factory{
    override  fun <T:ViewModel?> create(modelClass: Class<T>): T{
        return FilmsFragmentViewModel(repository) as T
    }
}

class VehiclesFragmentViewModelFactory(
    private val repository: Repository
): ViewModelProvider.Factory{
    override  fun <T:ViewModel?> create(modelClass: Class<T>): T{
        return VehiclesFragmentViewModel(repository) as T
    }
}

class SpeciesFragmentViewModelFactory(
    private val repository: Repository
): ViewModelProvider.Factory{
    override  fun <T:ViewModel?> create(modelClass: Class<T>): T{
        return SpeciesFragmentViewModel(repository) as T
    }
}