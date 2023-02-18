package com.example.futuretrajectory_semifinal.core_network.datasource.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL =
        "https://mobile-olympiad-trajectory.hb.bizmrg.com/"

    private var vkServiceApi: VKServiceApi? = null

    fun getFilmApi(): VKServiceApi {
        if (vkServiceApi == null) {
            configure()
        }
        return vkServiceApi!!
    }

    private fun configure() {
        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoginInterceptor)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        vkServiceApi = retrofit.create(VKServiceApi::class.java)
    }
}