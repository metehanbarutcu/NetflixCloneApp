package com.H5190019.ibrahim_metehan_barutcu.ui.category

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.H5190019.ibrahim_metehan_barutcu.R
import com.H5190019.ibrahim_metehan_barutcu.data.model.CategoryResponseItem
import com.H5190019.ibrahim_metehan_barutcu.databinding.ActivityCategoryBinding
import com.H5190019.ibrahim_metehan_barutcu.ui.films.FilmsActivity
import com.H5190019.ibrahim_metehan_barutcu.util.*
import java.util.*
import kotlin.collections.ArrayList

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
    var categoryViewModel: CategoryViewModel? = null
    private lateinit var categoryAdapter: CategoryAdapter
    var categoryList: ArrayList<CategoryResponseItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        init()
    }

    override fun onBackPressed() {
        AlertUtil.showExitAlert(this@CategoryActivity)

    }

    fun init() {
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ProgressUtil.startProgressDialog(this@CategoryActivity)
        initViewModel()
        binding.apply {
            serachView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    filterCategory(newText)
                    return true
                }
            })
        }
    }

    fun initViewModel() {
        categoryViewModel = CategoryViewModel()

        categoryViewModel?.apply {
            allCategoriesLiveData?.observe(this@CategoryActivity, Observer {
                it.run {
                    categoryList = it
                    initRecycleView(categoryList!!)
                    ProgressUtil.finishProgressDialog()
                }
            })

            error?.observe(this@CategoryActivity, Observer {
                it.run {
                    Toast.makeText(applicationContext, this.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            })
            loading?.observe(this@CategoryActivity, Observer {
                //Handle loading
            })
        }
    }

    fun initRecycleView(categories: ArrayList<CategoryResponseItem>) {

        binding.apply {

            categoryAdapter = CategoryAdapter(categories, object : ItemClickListener {

                override fun onItemClick(position: Int) {

                    var clickedCategory = categories.get(position)
                    openFilmsActivity(clickedCategory)
                }
            }, this@CategoryActivity)

            rcvCategories.adapter = categoryAdapter
            rcvCategories.layoutManager = GridLayoutManager(applicationContext, 2)
        }
    }

    fun filterCategory(text: String?) {

        text?.let {
            categoryList?.let {
                var filterList = it.filter {
                    it.categoryName?.lowercase()!!.contains(text.lowercase())
                } as ArrayList<CategoryResponseItem>
                initRecycleView(filterList)
                //categoryAdapter.setData(filterList)
                //categoryAdapter.notifyDataSetChanged()
            }
        }
    }

    fun openFilmsActivity(clickedCategory: CategoryResponseItem) {
        var intent = Intent(this@CategoryActivity, FilmsActivity::class.java)
        var clickedCategoryString = ObjectUtil.categoryToJsonString(clickedCategory)
        intent.putExtra(Constants.CLICKED_CATEGORY, clickedCategoryString)
        startActivity(intent)
    }
}