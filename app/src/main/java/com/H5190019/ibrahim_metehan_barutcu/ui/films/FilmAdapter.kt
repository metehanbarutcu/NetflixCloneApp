package com.H5190019.ibrahim_metehan_barutcu.ui.films

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.H5190019.ibrahim_metehan_barutcu.data.model.FilmResponseItem
import com.H5190019.ibrahim_metehan_barutcu.databinding.CardviewFilmBinding
import com.H5190019.ibrahim_metehan_barutcu.util.ItemClickListener
import com.H5190019.ibrahim_metehan_barutcu.util.GlideUtil


class FilmAdapter(
    var films: ArrayList<FilmResponseItem>,
    var onItemClickListener: ItemClickListener,
    var context: Context
) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CardviewFilmBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CardviewFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    fun setData(newFilmList: ArrayList<FilmResponseItem>) {
        films = newFilmList
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {

            binding.apply {

                binding.txtFilmName.text = films[position].filmName
                binding.txtImdb.text = films[position].ıMDB
                binding.txtDuration.text = films[position].duration
                GlideUtil.downloadAndShowImage(context, films[position].ımageURL, binding.imgFilm)

                filmCard.setOnClickListener {
                    onItemClickListener.onItemClick(position)
                }

            }
        }
    }
}