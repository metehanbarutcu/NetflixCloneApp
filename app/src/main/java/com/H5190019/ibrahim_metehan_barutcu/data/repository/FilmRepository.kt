package com.H5190019.ibrahim_metehan_barutcu.data.repository

import com.H5190019.ibrahim_metehan_barutcu.data.datasource.FilmDataSource
import com.H5190019.ibrahim_metehan_barutcu.data.model.FilmResponse
import com.H5190019.ibrahim_metehan_barutcu.data.datasource.remote.RemoteFilmDataSource
import com.H5190019.ibrahim_metehan_barutcu.util.Resource
import kotlinx.coroutines.flow.Flow

class FilmRepository {

    private var filmDataSource: FilmDataSource? = null

    init {
        filmDataSource = RemoteFilmDataSource()
    }

    fun getAllFilm(): Flow<Resource<FilmResponse>> {

        return filmDataSource!!.getAllFilm()
    }
}