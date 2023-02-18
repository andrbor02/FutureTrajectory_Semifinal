package com.example.futuretrajectory_semifinal.core_data.mapper

import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import com.example.futuretrajectory_semifinal.core_network.model.NetworkVKService

object NetworkToListItemVKServiceMapper: Mappers.VKService.NetworkToListItem {
    override fun invoke(networkVKService: NetworkVKService): VKServiceListItem {
        return VKServiceListItem(
            name = networkVKService.name,
            icon_url = networkVKService.icon_url,
        )
    }
}