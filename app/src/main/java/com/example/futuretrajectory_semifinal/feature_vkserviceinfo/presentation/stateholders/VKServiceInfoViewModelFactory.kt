package com.example.futuretrajectory_semifinal.feature_vkserviceinfo.presentation.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.futuretrajectory_semifinal.feature_vkserviceinfo.domain.usecase.GetVKServiceByNameUseCase

class VKServiceInfoViewModelFactory (
    private val getVKServiceByNameUseCase: GetVKServiceByNameUseCase,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        require(modelClass == VKServiceInfoViewModel::class)
        return VKServiceInfoViewModel(
            getVKServiceByNameUseCase = getVKServiceByNameUseCase,
        ) as T
    }

}