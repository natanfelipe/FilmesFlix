package com.br.natanfc.filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.model.Movie
import com.br.natanfc.filmesflix.repository.MovieRepository
class MovieListViewModel : ViewModel() {

    companion object {
        const val TAG = "MovieListViewModel"
    }

    private val movieRepository = MovieRepository()

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    fun init() {
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread {
            try {
                _moviesList.postValue(movieRepository.getAllMovies())
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
            }
        }.start()
    }

}