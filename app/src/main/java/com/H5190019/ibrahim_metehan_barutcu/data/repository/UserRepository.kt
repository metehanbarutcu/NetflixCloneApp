package com.H5190019.ibrahim_metehan_barutcu.data.repository

import com.H5190019.ibrahim_metehan_barutcu.data.datasource.UserDataSource
import com.H5190019.ibrahim_metehan_barutcu.data.model.UserResponse
import com.H5190019.ibrahim_metehan_barutcu.data.datasource.remote.RemoteUserDataSource
import com.H5190019.ibrahim_metehan_barutcu.util.Resource
import kotlinx.coroutines.flow.Flow

class UserRepository {

    private var userDataSource: UserDataSource? = null

    init {
        userDataSource = RemoteUserDataSource()
    }

    fun getAllUser(): Flow<Resource<UserResponse>> {

        return userDataSource!!.getAllUsers()
    }
}