package com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import com.example.futuretrajectory_semifinal.databinding.ServiceItemBinding

class VKServiceListAdapter(
    VKServiceListDiffUtil: VKServiceListDiffUtil,
    private val VKServiceClickListener: VKServiceClickListener
) :
    ListAdapter<VKServiceListItem, VKServiceListViewHolder>(VKServiceListDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VKServiceListViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val serviceItemBinding = ServiceItemBinding.inflate(layoutInflater, parent, false)

        return VKServiceListViewHolder(serviceItemBinding)
    }

    override fun onBindViewHolder(holder: VKServiceListViewHolder, position: Int) {
        holder.bindItem(getItem(position), VKServiceClickListener)
    }
}