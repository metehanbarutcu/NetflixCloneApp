package com.H5190019.ibrahim_metehan_barutcu.data.datasource.remote

import com.H5190019.ibrahim_metehan_barutcu.data.model.CategoryResponse
import com.H5190019.ibrahim_metehan_barutcu.data.datasource.CategoryDataSource
import com.H5190019.ibrahim_metehan_barutcu.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteCategoryDataSource : CategoryDataSource {

    override fun getAllCategory(): Flow<Resource<CategoryResponse>> = flow {
        try {
            emit(Resource.Loading())

            val response = ApiService.build().getAllCategory()

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