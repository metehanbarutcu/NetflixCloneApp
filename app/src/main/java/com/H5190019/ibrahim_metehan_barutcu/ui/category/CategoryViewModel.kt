package com.H5190019.ibrahim_metehan_barutcu.ui.category

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.H5190019.ibrahim_metehan_barutcu.data.model.CategoryResponse
import com.H5190019.ibrahim_metehan_barutcu.data.repository.CategoryRepository
import com.H5190019.ibrahim_metehan_barutcu.util.ResourceStatus
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {

    private val categoryRepository: CategoryRepository = CategoryRepository()

    init {
        getAllCategory()
    }

    var allCategoriesLiveData: MutableLiveData<CategoryResponse>? = MutableLiveData()
    var error: MutableLiveData<Throwable>? = MutableLiveData()
    var loading: MutableLiveData<Boolean>? = MutableLiveData()

    fun getAllCategory() = viewModelScope.launch {

        categoryRepository.getAllCategory()

            .asLiveData(viewModelScope.coroutineContext).observeForever {

                when (it.status) {
                    ResourceStatus.LOADING -> {
                        loading?.postValue(true)
                    }

                    ResourceStatus.SUCCESS -> {
                        allCategoriesLiveData?.postValue(it.data)
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



