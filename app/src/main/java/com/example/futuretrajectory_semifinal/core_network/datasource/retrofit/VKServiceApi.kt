package com.example.futuretrajectory_semifinal.core_network.datasource.retrofit

import com.example.futuretrajectory_semifinal.core_network.model.VKServiceResponse
import retrofit2.Call
import retrofit2.http.*

interface VKServiceApi {

    @GET("semi-final-data.json")
    fun getVKServiceList(): Call<VKServiceResponse>
}