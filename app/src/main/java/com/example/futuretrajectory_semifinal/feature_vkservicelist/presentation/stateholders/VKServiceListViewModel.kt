package com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.stateholders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import com.example.futuretrajectory_semifinal.feature_vkservicelist.domain.usecase.GetVKServiceListUseCase
import kotlinx.coroutines.launch
import com.example.futuretrajectory_semifinal.core_utils.datawrappers.Result

class VKServiceListViewModel (
    private val getVKServiceListUseCase: GetVKServiceListUseCase,
) : ViewModel() {

    private var _vkServiceListLD = MutableLiveData<Result<List<VKServiceListItem>>>()
    val vkServiceListLD: LiveData<Result<List<VKServiceListItem>>> = _vkServiceListLD

    init {
        initWithFilters()
    }

    private fun initWithFilters() {
        viewModelScope.launch {
            getVKServiceListUseCase().collect { _vkServiceListLD.value = it }
        }
    }

    fun tryAgain() {
        initWithFilters()
    }
}