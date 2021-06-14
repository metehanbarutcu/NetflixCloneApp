package com.H5190019.ibrahim_metehan_barutcu.util

import android.app.ProgressDialog
import android.content.Context
import com.H5190019.ibrahim_metehan_barutcu.R

object ProgressUtil {

    private lateinit var progressDialog: ProgressDialog

    fun startProgressDialog(context: Context) {
        progressDialog = ProgressDialog(context)
        progressDialog.setMessage(context.getString(R.string.pls_wait))
        progressDialog.setIcon(R.mipmap.ic_launcher)
        progressDialog.show()
    }

    fun finishProgressDialog() {
        progressDialog.dismiss()
    }
}