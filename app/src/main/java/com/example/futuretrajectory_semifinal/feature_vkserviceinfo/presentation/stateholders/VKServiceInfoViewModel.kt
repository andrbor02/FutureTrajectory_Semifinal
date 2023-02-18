package com.example.futuretrajectory_semifinal.feature_vkserviceinfo.presentation.stateholders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.futuretrajectory_semifinal.feature_vkserviceinfo.domain.usecase.GetVKServiceByNameUseCase
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceInfo
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result


class VKServiceInfoViewModel(
    private val getVKServiceByNameUseCase: GetVKServiceByNameUseCase,
) : ViewModel() {

    private var _currentVKServiceLD = MutableLiveData<Result<VKServiceInfo>>()
    val currentVKServiceLD: LiveData<Result<VKServiceInfo>> = _currentVKServiceLD

    fun getByName(name: String) {
        viewModelScope.launch {
            val result = getVKServiceByNameUseCase(name).first()
            _currentVKServiceLD.value = result
        }
    }
}