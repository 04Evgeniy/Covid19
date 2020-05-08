package com.example.covid19_statistics.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class CovidRepository : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO
    private val covidApi = Retrofit.Builder()
        .baseUrl(CovidApi.HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CovidApi::class.java)

    fun getSummary() = async {
        covidApi.getSummary()
            .execute()
            .body()

    }

    fun getRussiaLiveData() = async {
        covidApi.getByCountryLive("russia")
            .execute()
            .body()
            ?.last()
    }

    fun getRussiaData() = async {
        covidApi.getByCountryLastCases("russia")
            .execute()
            .body()
            ?.last()
    }

    fun getUsaData() = async {
        covidApi.getByCountryLastCases("United States of America")
            .execute()
            .body()
            ?.last()
    }
}