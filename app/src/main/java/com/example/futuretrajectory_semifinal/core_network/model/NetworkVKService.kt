package com.example.futuretrajectory_semifinal.core_network.model

import com.google.gson.annotations.SerializedName

data class NetworkVKService(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon_url")
    val icon_url: String,
    @SerializedName("service_url")
    val service_url: String,
)