package com.example.futuretrajectory_semifinal.core_network.datasource

import com.example.futuretrajectory_semifinal.core_network.model.NetworkVKService
import kotlinx.coroutines.flow.Flow
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result

interface VKServiceRemoteDataSource {

    suspend fun getVKServiceList(): Flow<Result<List<NetworkVKService>>>
}