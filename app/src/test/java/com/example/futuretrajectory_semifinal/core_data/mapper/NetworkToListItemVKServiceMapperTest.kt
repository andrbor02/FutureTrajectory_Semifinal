package com.example.futuretrajectory_semifinal.core_data.mapper

import com.example.futuretrajectory_semifinal.core_data.model.VKServiceInfo
import com.example.futuretrajectory_semifinal.core_data.model.VKServiceListItem
import com.example.futuretrajectory_semifinal.core_network.model.NetworkVKService
import junit.framework.TestCase
import org.junit.Test

class NetworkToListItemVKServiceMapperTest {

    @Test
    fun testInvoke() {
        val networkVKService = NetworkVKService(
            name = "Example Name",
            description = "Example Description",
            icon_url = "Example icon url",
            service_url = "Example service url",
        )


        val expected = VKServiceListItem(
            name = "Example Name",
            icon_url = "Example icon url",
        )
        val actual = NetworkToListItemVKServiceMapper(networkVKService)

        TestCase.assertEquals(expected, actual)
        NetworkToInfoVKServiceMapper
    }
}