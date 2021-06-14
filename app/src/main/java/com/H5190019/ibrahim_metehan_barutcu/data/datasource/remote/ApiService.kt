package com.H5190019.ibrahim_metehan_barutcu.data.datasource.remote

import com.H5190019.ibrahim_metehan_barutcu.data.model.CategoryResponse
import com.H5190019.ibrahim_metehan_barutcu.data.model.FilmResponse
import com.H5190019.ibrahim_metehan_barutcu.data.model.UserResponse
import com.H5190019.ibrahim_metehan_barutcu.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    //https://raw.githubusercontent.com/metehanbarutcu/NetflixClone/main/Category.json
    @GET("Category.json")
    suspend fun getAllCategory(): Response<CategoryResponse>

    //https://raw.githubusercontent.com/metehanbarutcu/NetflixClone/main/Films.json
    @GET("Film.json")
    suspend fun getAllFilm(): Response<FilmResponse>

    //https://raw.githubusercontent.com/metehanbarutcu/NetflixClone/main/User.json
    @GET("User.json")
    suspend fun getAllUsers(): Response<UserResponse>

    companion object {

        fun build(): ApiService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHtppClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(okHtppClient)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}