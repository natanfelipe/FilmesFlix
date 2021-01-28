package com.br.natanfc.filmesflix.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FilmeRestApiTask {

    companion object {
        const val BASE_URL = "https://run.mocky.io/v3/"
    }

    fun filmesProvider() : FilmeApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(FilmeApi::class.java)

}