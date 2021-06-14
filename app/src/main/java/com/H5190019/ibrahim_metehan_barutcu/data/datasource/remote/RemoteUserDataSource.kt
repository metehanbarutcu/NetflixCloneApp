package com.H5190019.ibrahim_metehan_barutcu.data.datasource.remote

import com.H5190019.ibrahim_metehan_barutcu.data.model.UserResponse
import com.H5190019.ibrahim_metehan_barutcu.data.datasource.UserDataSource
import com.H5190019.ibrahim_metehan_barutcu.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteUserDataSource : UserDataSource {

    override fun getAllUsers(): Flow<Resource<UserResponse>> = flow {
        try {
            emit(Resource.Loading())

            val response = ApiService.build().getAllUsers()

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