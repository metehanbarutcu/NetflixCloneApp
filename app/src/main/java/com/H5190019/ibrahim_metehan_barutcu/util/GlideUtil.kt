package com.H5190019.ibrahim_metehan_barutcu.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

object GlideUtil {

    fun downloadAndShowImage(context: Context?, url: String?, img: ImageView?) {
        if (img != null) {
            Glide.with(context!!)
                .load(url)
                .centerCrop()
                .into(img)
        }
    }
}