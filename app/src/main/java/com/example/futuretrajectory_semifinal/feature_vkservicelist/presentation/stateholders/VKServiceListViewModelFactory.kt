package com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.futuretrajectory_semifinal.feature_vkservicelist.domain.usecase.GetVKServiceListUseCase

class VKServiceListViewModelFactory (
    private val getVKServiceListUseCase: GetVKServiceListUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == VKServiceListViewModel::class)
        return VKServiceListViewModel(
            getVKServiceListUseCase = getVKServiceListUseCase,
        ) as T
    }
}