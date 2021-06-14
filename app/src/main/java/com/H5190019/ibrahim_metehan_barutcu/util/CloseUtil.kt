package com.H5190019.ibrahim_metehan_barutcu.util

import android.app.Activity
import android.content.Context

object CloseUtil {

    fun closeApp(context: Context) {
        (context as Activity).finishAffinity()
    }
}