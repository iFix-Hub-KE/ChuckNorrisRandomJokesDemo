package com.kanyideveloper.chucknorrisjokesapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("jokes/random/20/")
    fun getJokes() : Call<Jokes>
}

object JokesApi{
    const val BASE_URL = "https://api.icndb.com/"


    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService by lazy {
        retrofit.create(ApiService::class.java)
    }
}