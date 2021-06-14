package com.H5190019.ibrahim_metehan_barutcu.data.datasource.remote

import com.H5190019.ibrahim_metehan_barutcu.data.model.FilmResponse
import com.H5190019.ibrahim_metehan_barutcu.data.datasource.FilmDataSource
import com.H5190019.ibrahim_metehan_barutcu.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class RemoteFilmDataSource : FilmDataSource {

    override fun getAllFilm(): Flow<Resource<FilmResponse>> = flow {
        try {
            emit(Resource.Loading())

            val response = ApiService.build().getAllFilm()

            if (response.isSuccessful) {

                response.body()?.let {
                    emit(Resource.Success(it))
                }
            }

        } catch (e: Exception) {
            emit(Resource.Error(e))
            e.printStackTrace()
        }
    }

}