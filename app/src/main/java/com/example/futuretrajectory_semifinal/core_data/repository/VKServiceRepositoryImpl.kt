package com.example.futuretrajectory_semifinal.core_data.repository

import android.content.res.Resources.NotFoundException
import android.util.Log
import com.example.futuretrajectory_semifinal.core_data.mapper.NetworkToInfoVKServiceMapper
import com.example.futuretrajectory_semifinal.core_data.mapper.NetworkToListItemVKServiceMapper
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceInfo
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import com.example.futuretrajectory_semifinal.core_network.client.NetworkClient
import com.example.futuretrajectory_semifinal.core_network.model.NetworkVKService
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.*

class VKServiceRepositoryImpl(
    networkClient: NetworkClient,
) : VKServiceRepository {

    private val networkDataSource = networkClient.getVKServiceRemoteDataSource()


    override suspend fun getAll(): Flow<Result<List<VKServiceListItem>>> {
        return networkDataSource.getVKServiceList().map { result ->
            result.map { networkList ->
                networkList.map { networkVKService ->
                    NetworkToListItemVKServiceMapper(networkVKService)
                }
            }
        }
    }

    override suspend fun getByName(name: String): Flow<Result<VKServiceInfo>> {
        return networkDataSource.getVKServiceList().map { result ->
            result.map { networkList ->
                val vkService = networkList.find { it.name == name }
                    ?: NetworkVKService(
                        "No such service", "", "", ""
                    )
                NetworkToInfoVKServiceMapper(vkService)
            }
        }
    }
}