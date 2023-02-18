package com.example.futuretrajectory_semifinal.core_data.repository

import com.example.futuretrajectory_semifinal.core_data.model.VKServiceInfo
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import kotlinx.coroutines.flow.Flow
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result

interface VKServiceRepository {

    suspend fun getAll(): Flow<Result<List<VKServiceListItem>>>

    suspend fun getByName(name: String): Flow<Result<VKServiceInfo>>
}