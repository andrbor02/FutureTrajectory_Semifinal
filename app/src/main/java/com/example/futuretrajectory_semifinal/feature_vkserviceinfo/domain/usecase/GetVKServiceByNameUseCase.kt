package com.example.futuretrajectory_semifinal.feature_vkserviceinfo.domain.usecase

import android.util.Log
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceInfo
import com.example.futuretrajectory_semifinal.core_data.repository.VKServiceRepository
import kotlinx.coroutines.flow.Flow
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class GetVKServiceByNameUseCase (
    private val repository: VKServiceRepository
) {
    suspend operator fun invoke(name: String): Flow<Result<VKServiceInfo>> {
        return repository.getByName(name)
    }
}