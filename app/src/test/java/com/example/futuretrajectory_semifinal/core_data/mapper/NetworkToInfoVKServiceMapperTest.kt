package com.example.futuretrajectory_semifinal.core_data.mapper

import com.example.futuretrajectory_semifinal.core_data.model.VKServiceInfo
import com.example.futuretrajectory_semifinal.core_network.model.NetworkVKService
import junit.framework.TestCase.assertEquals
import org.junit.Test

class NetworkToInfoVKServiceMapperTest {
    @Test
    fun testInvoke() {
        val networkVKService = NetworkVKService(
            name = "Example Name",
            description = "Example Description",
            icon_url = "Example icon url",
            service_url = "Example service url",
        )


        val expected = VKServiceInfo(
            name = "Example Name",
            description = "Example Description",
            icon_url = "Example icon url",
            service_url = "Example service url",
        )
        val actual = NetworkToInfoVKServiceMapper(networkVKService)

        assertEquals(expected, actual)
        NetworkToInfoVKServiceMapper
    }
}