package com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.recycler

import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem


interface VKServiceClickListener {
    fun onItemClick(vkServiceListItem: VKServiceListItem)
}