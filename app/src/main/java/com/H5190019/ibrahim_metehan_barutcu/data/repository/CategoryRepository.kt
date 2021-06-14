package com.H5190019.ibrahim_metehan_barutcu.data.repository

import com.H5190019.ibrahim_metehan_barutcu.data.datasource.CategoryDataSource
import com.H5190019.ibrahim_metehan_barutcu.data.model.CategoryResponse
import com.H5190019.ibrahim_metehan_barutcu.data.datasource.remote.RemoteCategoryDataSource
import com.H5190019.ibrahim_metehan_barutcu.util.Resource
import kotlinx.coroutines.flow.Flow

class CategoryRepository {

    private var categoryDataSource: CategoryDataSource? = null

    init {
        categoryDataSource = RemoteCategoryDataSource()
    }

    fun getAllCategory(): Flow<Resource<CategoryResponse>> {

        return categoryDataSource!!.getAllCategory()
    }

}