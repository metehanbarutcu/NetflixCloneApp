package com.H5190019.ibrahim_metehan_barutcu.data.model

import com.google.gson.annotations.SerializedName

class UserResponse : ArrayList<UserResponseItem>()

data class UserResponseItem(
    @SerializedName("Password")
    val password: String?,
    @SerializedName("UserEmail")
    val userEmail: String?,
    @SerializedName("UserName")
    val userName: String?,
    @SerializedName("UserSurname")
    val userSurname: String?
)