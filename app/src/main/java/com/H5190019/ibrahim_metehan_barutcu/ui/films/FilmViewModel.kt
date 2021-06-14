package com.H5190019.ibrahim_metehan_barutcu.ui.films

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.H5190019.ibrahim_metehan_barutcu.data.model.FilmResponse
import com.H5190019.ibrahim_metehan_barutcu.data.repository.FilmRepository
import com.H5190019.ibrahim_metehan_barutcu.util.ResourceStatus
import kotlinx.coroutines.launch

class FilmViewModel : ViewModel() {

    private val filmRepository: FilmRepository = FilmRepository()

    init {
        gelAllFilm()
    }

    var allFilmsLiveData: MutableLiveData<FilmResponse>? = MutableLiveData()
    var error: MutableLiveData<Throwable>? = MutableLiveData()
    var loading: MutableLiveData<Boolean>? = MutableLiveData()

    fun gelAllFilm() = viewModelScope.launch {

        filmRepository.getAllFilm()

            .asLiveData(viewModelScope.coroutineContext).observeForever {

                when (it.status) {
                    ResourceStatus.LOADING -> {
                        loading?.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        allFilmsLiveData?.postValue(it.data)
                        loading?.postValue(false)
                    }
                    ResourceStatus.ERROR -> {
                        Log.e("ERROR", "${it.throwable}")
                        error?.postValue(it.throwable!!)
                        loading?.postValue(false)
                    }
                }
            }
    }
}