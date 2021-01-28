package com.br.natanfc.filmesflix.data

import com.br.natanfc.filmesflix.model.Filme
import retrofit2.http.GET

interface FilmeApi {
    @GET ("c28d3e9a-f275-4b57-85af-5d159fbdecc6")
    fun getTodosOsFilmes(): List<Filme>
}