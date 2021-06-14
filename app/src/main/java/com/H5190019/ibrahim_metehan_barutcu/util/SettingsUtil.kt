package com.H5190019.ibrahim_metehan_barutcu.util

import android.content.Context
import android.content.Intent
import android.provider.Settings


object SettingsUtil {

    fun openInternetSettings(context: Context) {
        val settings = Intent(Settings.ACTION_WIRELESS_SETTINGS)
        context.startActivity(settings)
    }

}