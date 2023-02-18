package com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem

class VKServiceListDiffUtil : DiffUtil.ItemCallback<VKServiceListItem>() {
    override fun areItemsTheSame(oldItem: VKServiceListItem, newItem: VKServiceListItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: VKServiceListItem, newItem: VKServiceListItem): Boolean {
        return oldItem == newItem
    }
}