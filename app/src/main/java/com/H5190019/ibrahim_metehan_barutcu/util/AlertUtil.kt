package com.H5190019.ibrahim_metehan_barutcu.util

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import com.H5190019.ibrahim_metehan_barutcu.R
import com.H5190019.ibrahim_metehan_barutcu.data.model.FilmResponseItem
import com.H5190019.ibrahim_metehan_barutcu.ui.films.FilmAdapter

object AlertUtil {

    fun checkInternetAlert(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(context.resources.getString(R.string.internet_alert_title))
        builder.setMessage(context.resources.getString(R.string.internet_app))
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setPositiveButton(
            context.resources.getString(R.string.open_internet)
        ) { dialog, which -> SettingsUtil.openInternetSettings(context) }
        builder.setNegativeButton(
            context.resources.getString(R.string.close_app)
        ) { dialog, which ->
            CloseUtil.closeApp(context)
        }
        builder.show()
    }

    fun showExitAlert(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(context.resources.getString(R.string.exit_title))
        builder.setMessage(context.resources.getString(R.string.exit_app))
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setPositiveButton(
            context.resources.getString(R.string.exit_no)
        ) { dialog, which -> dialog.dismiss() }
        builder.setNegativeButton(
            context.resources.getString(R.string.exit_yes)
        ) { dialog, which -> CloseUtil.closeApp(context) }
        builder.show()
    }


    fun showSortFilmAlert(
        context: Context,
        adapter: FilmAdapter,
        films: ArrayList<FilmResponseItem>
    ) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(context.getString(R.string.pick))
        val sortTypes =
            arrayOf(
                context.getString(R.string.sort_by),
                context.getString(R.string.sort_by_descending),
                context.getString(R.string.sort_by_Imdb),
                context.getString(R.string.sort_by_descending_Imdb)
            )

        builder.setItems(sortTypes) { dialog, position ->
            when (position) {
                0 -> {
                    films.sortBy { it.filmName }
                    Log.e("Sorted:", "" + films)
                    adapter.setData(films)
                    adapter.notifyDataSetChanged()
                }
                1 -> {
                    films.sortByDescending { it.filmName }
                    Log.e("SortedDescending:", "" + films)
                    adapter.setData(films)
                    adapter.notifyDataSetChanged()
                }
                2 -> {
                    films.sortBy { it.ıMDB }
                    Log.e("SortedImdb:", "" + films)
                    adapter.setData(films)
                    adapter.notifyDataSetChanged()
                }
                3 -> {
                    films.sortByDescending { it.ıMDB }
                    Log.e("SortedDescendingImdb:", "" + films)
                    adapter.setData(films)
                    adapter.notifyDataSetChanged()
                }
            }
        }
        val dialog = builder.create()
        dialog.show()
    }
}
