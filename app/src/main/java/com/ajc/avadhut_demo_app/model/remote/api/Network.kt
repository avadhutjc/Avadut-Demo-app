package com.ajc.avadhut_demo_app.model.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {
        private const val BaseUrl = "https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}