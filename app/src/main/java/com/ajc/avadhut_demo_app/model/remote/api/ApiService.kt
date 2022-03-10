package com.ajc.avadhut_demo_app.model.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("api/covid-ovid-data/sixmonth/IND")
    suspend fun getData(
        @Header("x-rapidapi-host") token: String,
        @Header("x-rapidapi-key") token1: String

    ): Response<com.ajc.avadhut_demo_app.model.remote.ResponseDTOItem>
}