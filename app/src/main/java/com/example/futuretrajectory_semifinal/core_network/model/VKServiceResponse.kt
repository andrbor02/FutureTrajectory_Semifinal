package com.example.futuretrajectory_semifinal.core_network.model

import com.example.futuretrajectory_semifinal.core_network.model.NetworkVKService
import com.google.gson.annotations.SerializedName

data class VKServiceResponse(
    @SerializedName("items")
    val list: List<NetworkVKService>
)