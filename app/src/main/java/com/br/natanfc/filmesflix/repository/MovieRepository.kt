package com.br.natanfc.filmesflix.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.br.natanfc.filmesflix.api.MovieRestApiTask
import com.br.natanfc.filmesflix.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository {

    companion object {
        const val TAG = "MovieRepository"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private var movieList = MutableLiveData<List<Movie>>()

    fun getAllMovies(): MutableLiveData<List<Movie>> {

        movieRestApiTask.retrofitApi().getAllMovies().enqueue(object: Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                response.body()?.let { list ->
                    if (list.isNotEmpty()) {
                        movieList.value = list
                    }
                }
            }

            override fun onFailure(call: Call<List<Movie>>, throwable: Throwable) {
                Log.d(TAG, throwable.message.toString())
            }

        })

        return movieList
    }


}