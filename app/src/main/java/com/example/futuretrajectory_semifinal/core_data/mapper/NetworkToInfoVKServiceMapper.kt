package com.example.futuretrajectory_semifinal.core_data.mapper

import com.example.futuretrajectory_semifinal.core_data.model.VKServiceInfo
import com.example.futuretrajectory_semifinal.core_network.model.NetworkVKService

object NetworkToInfoVKServiceMapper: Mappers.VKService.NetworkToInfo {
    override fun invoke(networkVKService: NetworkVKService): VKServiceInfo {
        return VKServiceInfo(
            name = networkVKService.name,
            description = networkVKService.description,
            icon_url = networkVKService.icon_url,
            service_url = networkVKService.service_url,
        )
    }
}