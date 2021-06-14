package com.H5190019.ibrahim_metehan_barutcu.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.H5190019.ibrahim_metehan_barutcu.R
import com.H5190019.ibrahim_metehan_barutcu.data.model.UserResponseItem
import com.H5190019.ibrahim_metehan_barutcu.databinding.ActivityLoginBinding
import com.H5190019.ibrahim_metehan_barutcu.ui.category.CategoryActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    var loginViewModel: LoginViewModel? = null
    var users: ArrayList<UserResponseItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

    }

    fun init() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        checkLogin()
    }

    fun initViewModel() {
        loginViewModel = LoginViewModel()
        loginViewModel?.apply {
            allUsersLiveData?.observe(this@LoginActivity, Observer {
                users = it
            })

            error?.observe(this@LoginActivity, Observer {
                it.run {
                    Toast.makeText(applicationContext, this.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            })
            loading?.observe(this@LoginActivity, Observer {
                //Handle loading
            })
        }
    }

    fun checkLogin() {
        binding.apply {
            lnrLogin.setOnClickListener(View.OnClickListener {

                var email = edtEmail.text.toString()
                var password = edtPassword.text.toString()

                if (email.isEmpty()) {
                    edtEmail.setError("Bu alan boş bırakılamaz!")
                    edtEmail.requestFocus()
                    return@OnClickListener
                }
                if (password.isEmpty()) {
                    edtPassword.setError("Bu alan boş bırakılamaz!")
                    edtPassword.requestFocus()
                    return@OnClickListener
                }

                var loginUser = users?.filter {
                    it.userEmail.toString().equals(email) && it.password.toString()
                        .equals(password)
                }

                if (loginUser!!.count() > 0) {
                    Log.e("Login", " " + loginUser)
                    startActivity(Intent(this@LoginActivity, CategoryActivity::class.java))
                } else
                    Toast.makeText(
                        this@LoginActivity,
                        getString(R.string.wrong_login),
                        Toast.LENGTH_SHORT
                    ).show()
            })
        }
    }
}

