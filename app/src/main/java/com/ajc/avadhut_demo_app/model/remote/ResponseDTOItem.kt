package com.ajc.avadhut_demo_app.model.remote

import com.google.gson.annotations.SerializedName

data class ResponseDTOItem(
    @SerializedName("Continent")
    val continent: String?,
    @SerializedName("Country")
    val country: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("new_cases")
    val newCases: Int?,
    @SerializedName("new_deaths")
    val newDeaths: Int?,
    @SerializedName("new_tests")
    val newTests: Int?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("total_cases")
    val totalCases: Int?,
    @SerializedName("total_deaths")
    val totalDeaths: Int?,
    @SerializedName("total_tests")
    val totalTests: Int?
)