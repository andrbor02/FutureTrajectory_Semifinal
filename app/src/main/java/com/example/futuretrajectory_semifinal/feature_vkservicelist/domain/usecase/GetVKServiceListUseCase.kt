package com.example.futuretrajectory_semifinal.feature_vkservicelist.domain.usecase

import android.util.Log
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import com.example.futuretrajectory_semifinal.core_data.repository.VKServiceRepository
import kotlinx.coroutines.flow.Flow
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count

class GetVKServiceListUseCase (
    private val vkServiceRepository: VKServiceRepository
) {
    suspend operator fun invoke(): Flow<Result<List<VKServiceListItem>>> {
        return vkServiceRepository.getAll()
    }
}