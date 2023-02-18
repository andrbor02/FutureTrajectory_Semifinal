package com.example.futuretrajectory_semifinal.core_network.client

import com.example.futuretrajectory_semifinal.core_network.datasource.VKServiceRemoteDataSource

interface NetworkClient {

    fun getVKServiceRemoteDataSource(): VKServiceRemoteDataSource
}