package com.example.futuretrajectory_semifinal.core_network.datasource.retrofit

import android.util.Log
import com.example.futuretrajectory_semifinal.core_network.datasource.VKServiceRemoteDataSource
import com.example.futuretrajectory_semifinal.core_network.model.NetworkVKService
import com.example.futuretrajectory_semifinal.core_network.model.VKServiceResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result

class VKServiceRemoteDataSourceImpl(
    private val VKServiceApi: VKServiceApi,
) : VKServiceRemoteDataSource {

    val vkServiceListFlow = MutableStateFlow<Result<List<NetworkVKService>>>(Result.Loading())

    override suspend fun getVKServiceList(): Flow<Result<List<NetworkVKService>>> {
        VKServiceApi.getVKServiceList().enqueue(object : Callback<VKServiceResponse> {
            override fun onResponse(
                call: Call<VKServiceResponse>,
                response: Response<VKServiceResponse>
            ) {

                vkServiceListFlow.value = Result.Success(
                    response.body()?.list ?: emptyList()
                )
            }

            override fun onFailure(call: Call<VKServiceResponse>, t: Throwable) {
                vkServiceListFlow.value = Result.Error(t)
            }
        })
        return vkServiceListFlow
    }
}