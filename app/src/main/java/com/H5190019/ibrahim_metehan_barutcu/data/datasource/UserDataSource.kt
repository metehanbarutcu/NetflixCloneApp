package com.H5190019.ibrahim_metehan_barutcu.data.datasource

import com.H5190019.ibrahim_metehan_barutcu.data.model.UserResponse
import com.H5190019.ibrahim_metehan_barutcu.util.Resource
import kotlinx.coroutines.flow.Flow

interface UserDataSource {

    fun getAllUsers(): Flow<Resource<UserResponse>>

}