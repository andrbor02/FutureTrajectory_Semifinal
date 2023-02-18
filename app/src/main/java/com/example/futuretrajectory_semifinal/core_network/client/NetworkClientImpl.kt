package com.example.futuretrajectory_semifinal.core_network.client

import com.example.futuretrajectory_semifinal.core_network.datasource.VKServiceRemoteDataSource

class NetworkClientImpl (
    private val VKServiceRemoteDataSource: VKServiceRemoteDataSource
) : NetworkClient {

    override fun getVKServiceRemoteDataSource(): VKServiceRemoteDataSource {
        return VKServiceRemoteDataSource
    }
}