package com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.recycler

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import com.example.futuretrajectory_semifinal.databinding.ServiceItemBinding

import com.example.futuretrajectory_semifinal.feature_vkservicelist.presentation.recycler.VKServiceClickListener

class VKServiceListViewHolder(
    private val binding: ServiceItemBinding
) : RecyclerView.ViewHolder(binding.root) {


    @SuppressLint("ResourceAsColor")
    fun bindItem(vkServiceListItem: VKServiceListItem, listener: VKServiceClickListener) {
        binding.apply {
//            poster
            name.text = vkServiceListItem.name

            filmItem.setOnClickListener { listener.onItemClick(vkServiceListItem) }
        }
    }
}