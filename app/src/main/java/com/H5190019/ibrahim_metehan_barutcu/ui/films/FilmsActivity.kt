package com.H5190019.ibrahim_metehan_barutcu.ui.films

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.H5190019.ibrahim_metehan_barutcu.R
import com.H5190019.ibrahim_metehan_barutcu.data.model.FilmResponseItem
import com.H5190019.ibrahim_metehan_barutcu.databinding.ActivityFilmsBinding
import com.H5190019.ibrahim_metehan_barutcu.ui.detail.DetailActivity
import com.H5190019.ibrahim_metehan_barutcu.util.*

class FilmsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilmsBinding
    var filmViewModel: FilmViewModel? = null
    private lateinit var filmAdapter: FilmAdapter
    var filmList: ArrayList<FilmResponseItem>? = null
    var categoryId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)
        init()

    }

    fun init() {
        binding = ActivityFilmsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        filterFilm()
        ProgressUtil.startProgressDialog(this@FilmsActivity)
        var movedCategory = intent.getStringExtra(Constants.CLICKED_CATEGORY)
        var category = ObjectUtil.jsonStringToCategory(movedCategory)
        categoryId = category?.categoryId!!
    }

    fun initViewModel() {
        filmViewModel = FilmViewModel()
        filmViewModel?.apply {
            allFilmsLiveData?.observe(this@FilmsActivity, Observer {
                it.run {
                    filmList =
                        it.filter { it.categoryId == categoryId } as ArrayList<FilmResponseItem>
                    initRecycleView(filmList as ArrayList<FilmResponseItem>)
                }
            })

            error?.observe(this@FilmsActivity, Observer {
                it.run {
                    Toast.makeText(applicationContext, this.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            })
            loading?.observe(this@FilmsActivity, Observer {
                //Handle loading
                ProgressUtil.finishProgressDialog()
            })
        }
    }

    fun initRecycleView(films: ArrayList<FilmResponseItem>) {

        binding.apply {
            filmAdapter = FilmAdapter(films, object : ItemClickListener {

                override fun onItemClick(position: Int) {

                    var clickedFilm = films.get(position)
                    openDetailActivity(clickedFilm)
                }

            }, this@FilmsActivity)

            rcvFilms.adapter = filmAdapter
            rcvFilms.layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            switchGrid.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked)
                    rcvFilms.layoutManager = GridLayoutManager(applicationContext, 2)
                else
                    rcvFilms.layoutManager =
                        LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            }
        }
    }

    fun openDetailActivity(clickedFilm: FilmResponseItem) {
        var intent = Intent(this@FilmsActivity, DetailActivity::class.java)
        var clickedFilmString = ObjectUtil.filmToJsonString(clickedFilm)
        intent.putExtra(Constants.CLICKED_FILM, clickedFilmString)
        startActivity(intent)
    }

    fun filterFilm() {
        binding.apply {
            btnSort.setOnClickListener({
                AlertUtil.showSortFilmAlert(this@FilmsActivity, filmAdapter, filmList!!)
            })
        }
    }
}
