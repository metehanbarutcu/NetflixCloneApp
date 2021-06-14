package com.H5190019.ibrahim_metehan_barutcu.data.model

import com.google.gson.annotations.SerializedName

class CategoryResponse : ArrayList<CategoryResponseItem>()

data class CategoryResponseItem(
    @SerializedName("CategoryId")
    val categoryId: Int?,
    @SerializedName("CategoryName")
    val categoryName: String?,
    @SerializedName("Desc")
    val desc: String?,
    @SerializedName("ImageUrl")
    val ımageUrl: String?
)