package com.example.futuretrajectory_semifinal

import com.example.futuretrajectory_semifinal.core_data.repository.VKServiceRepository
import com.example.futuretrajectory_semifinal.core_data.repository.VKServiceRepositoryImpl
import com.example.futuretrajectory_semifinal.core_network.client.NetworkClient
import com.example.futuretrajectory_semifinal.core_network.client.NetworkClientImpl
import com.example.futuretrajectory_semifinal.core_network.datasource.VKServiceRemoteDataSource
import com.example.futuretrajectory_semifinal.core_network.datasource.retrofit.RetrofitClient
import com.example.futuretrajectory_semifinal.core_network.datasource.retrofit.VKServiceApi
import com.example.futuretrajectory_semifinal.core_network.datasource.retrofit.VKServiceRemoteDataSourceImpl

object IoC {
    private var repository: VKServiceRepository? = null

    fun getRepository(): VKServiceRepository {
        if (repository == null) {
            val vkServiceApi: VKServiceApi =
                RetrofitClient.getFilmApi()
            val vkServiceRemoteDataSource: VKServiceRemoteDataSource =
                VKServiceRemoteDataSourceImpl(vkServiceApi)
            val networkClient: NetworkClient =
                NetworkClientImpl(vkServiceRemoteDataSource)
            val vkServiceRepository: VKServiceRepository =
                VKServiceRepositoryImpl(networkClient)
            repository = vkServiceRepository
        }
        return repository!!
    }
}