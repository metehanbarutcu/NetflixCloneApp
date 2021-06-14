package com.H5190019.ibrahim_metehan_barutcu.data.model

import com.google.gson.annotations.SerializedName

class FilmResponse : ArrayList<FilmResponseItem>()

data class FilmResponseItem(
    @SerializedName("CategoryId")
    val categoryId: Int?,
    @SerializedName("Country")
    val country: String?,
    @SerializedName("Director")
    val director: String?,
    @SerializedName("Duration")
    val duration: String?,
    @SerializedName("FilmName")
    val filmName: String?,
    @SerializedName("HeaderImageURL")
    val headerImageURL: String?,
    @SerializedName("Plot")
    val plot: String?,
    @SerializedName("ReleaseDate")
    val releaseDate: String?,
    @SerializedName("Type")
    val type: String?,
    @SerializedName("IMDB")
    val ıMDB: String?,
    @SerializedName("ImageURL")
    val ımageURL: String?
)
