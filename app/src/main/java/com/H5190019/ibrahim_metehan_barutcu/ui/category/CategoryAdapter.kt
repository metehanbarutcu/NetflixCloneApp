package com.H5190019.ibrahim_metehan_barutcu.ui.category

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.H5190019.ibrahim_metehan_barutcu.data.model.CategoryResponseItem
import com.H5190019.ibrahim_metehan_barutcu.databinding.CardviewCategoryBinding
import com.H5190019.ibrahim_metehan_barutcu.util.ItemClickListener
import com.H5190019.ibrahim_metehan_barutcu.util.GlideUtil

class CategoryAdapter(
    var categories: ArrayList<CategoryResponseItem>,
    var onItemClickListener: ItemClickListener,
    var context: Context
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CardviewCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CardviewCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun setData(newCategories: ArrayList<CategoryResponseItem>) {
        categories = newCategories
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {

            binding.apply {

                binding.txtCategoryName.text = categories[position].categoryName
                binding.txtCategoryDesc.text = categories[position].desc
                GlideUtil.downloadAndShowImage(
                    context,
                    categories[position].ımageUrl,
                    binding.imgCategory
                )

                categoryCard.setOnClickListener {
                    onItemClickListener.onItemClick(position)
                }

            }
        }
    }
}