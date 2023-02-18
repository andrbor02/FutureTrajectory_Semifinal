package com.example.futuretrajectory_semifinal.core_data.mapper

import com.example.futuretrajectory_semifinal.core_data.model.VKServiceInfo
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import com.example.futuretrajectory_semifinal.core_network.model.NetworkVKService


interface Mappers {

    interface VKService {
        interface NetworkToInfo {
            operator fun invoke(networkVKService: NetworkVKService): VKServiceInfo
        }

        interface NetworkToListItem {
            operator fun invoke(networkVKService: NetworkVKService): VKServiceListItem
        }
    }
}