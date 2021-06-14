package com.H5190019.ibrahim_metehan_barutcu.util

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtil {

    fun isInternetAvailable(context: Context): Boolean? {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return if (networkInfo != null && networkInfo.isAvailable && networkInfo.isConnected) {
            true
        } else {
            false
        }
    }
}