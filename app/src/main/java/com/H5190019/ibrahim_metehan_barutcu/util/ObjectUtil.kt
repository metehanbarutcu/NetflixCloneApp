package com.H5190019.ibrahim_metehan_barutcu.util

import com.H5190019.ibrahim_metehan_barutcu.data.model.CategoryResponseItem
import com.H5190019.ibrahim_metehan_barutcu.data.model.FilmResponseItem
import com.google.gson.Gson

object ObjectUtil {

    fun categoryToJsonString(categoryResponseItem: CategoryResponseItem?): String? {
        val gson = Gson()
        return gson.toJson(categoryResponseItem)
    }

    fun jsonStringToCategory(jsonString: String?): CategoryResponseItem? {
        val gson = Gson()
        return gson.fromJson(jsonString, CategoryResponseItem::class.java)
    }

    fun filmToJsonString(filmResponseItem: FilmResponseItem?): String? {
        val gson = Gson()
        return gson.toJson(filmResponseItem)
    }

    fun jsonStringToFilm(jsonString: String?): FilmResponseItem? {
        val gson = Gson()
        return gson.fromJson(jsonString, FilmResponseItem::class.java)
    }

}