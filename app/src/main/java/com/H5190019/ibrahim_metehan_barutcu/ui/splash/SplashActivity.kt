package com.H5190019.ibrahim_metehan_barutcu.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.H5190019.ibrahim_metehan_barutcu.R
import com.H5190019.ibrahim_metehan_barutcu.ui.login.LoginActivity
import com.H5190019.ibrahim_metehan_barutcu.util.AlertUtil
import com.H5190019.ibrahim_metehan_barutcu.util.NetworkUtil

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()

    }

    fun init() {
        checkInternet()
    }

    private fun checkInternet() {
        if (NetworkUtil.isInternetAvailable(this@SplashActivity)!!) {
            startTimer()
        } else {
            AlertUtil.checkInternetAlert(this@SplashActivity)
        }
    }

    fun startTimer() {

        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                openLoginActivity()
            }
        }.start()
    }

    fun openLoginActivity() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
    }
}