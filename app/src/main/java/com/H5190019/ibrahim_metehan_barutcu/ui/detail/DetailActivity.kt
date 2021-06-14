package com.H5190019.ibrahim_metehan_barutcu.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.H5190019.ibrahim_metehan_barutcu.R
import com.H5190019.ibrahim_metehan_barutcu.databinding.ActivityDetailBinding
import com.H5190019.ibrahim_metehan_barutcu.util.Constants
import com.H5190019.ibrahim_metehan_barutcu.util.GlideUtil
import com.H5190019.ibrahim_metehan_barutcu.util.ObjectUtil

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        init()

    }

    fun init() {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            var movedFilmString = intent.getStringExtra(Constants.CLICKED_FILM)
            var film = ObjectUtil.jsonStringToFilm(movedFilmString)

            txtCountry.text = film!!.country
            txtDirector.text = film!!.director
            txtDuration.text = film!!.duration
            txtImdb.text = film!!.ıMDB
            txtReleaseDate.text = film!!.releaseDate
            txtPlot.text = film!!.plot
            txtFilmName.text = film!!.filmName
            txtFilmType.text = film!!.type
            GlideUtil.downloadAndShowImage(
                this@DetailActivity,
                film!!.headerImageURL,
                imgFilmBanner
            )

        }
    }
}