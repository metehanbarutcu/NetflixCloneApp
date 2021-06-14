package com.H5190019.ibrahim_metehan_barutcu.data.datasource

import com.H5190019.ibrahim_metehan_barutcu.data.model.FilmResponse
import com.H5190019.ibrahim_metehan_barutcu.util.Resource
import kotlinx.coroutines.flow.Flow

interface FilmDataSource {

    fun getAllFilm(): Flow<Resource<FilmResponse>>

}