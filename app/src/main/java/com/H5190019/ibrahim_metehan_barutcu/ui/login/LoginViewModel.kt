package com.H5190019.ibrahim_metehan_barutcu.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.H5190019.ibrahim_metehan_barutcu.data.model.UserResponse
import com.H5190019.ibrahim_metehan_barutcu.data.repository.UserRepository
import com.H5190019.ibrahim_metehan_barutcu.util.ResourceStatus
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val userRepository: UserRepository = UserRepository()

    init {
        getAllUsers()
    }

    var allUsersLiveData: MutableLiveData<UserResponse>? = MutableLiveData()
    var error: MutableLiveData<Throwable>? = MutableLiveData()
    var loading: MutableLiveData<Boolean>? = MutableLiveData()

    fun getAllUsers() = viewModelScope.launch {

        userRepository.getAllUser()

            .asLiveData(viewModelScope.coroutineContext).observeForever {

                when (it.status) {
                    ResourceStatus.LOADING -> {
                        loading?.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        allUsersLiveData?.postValue(it.data)
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