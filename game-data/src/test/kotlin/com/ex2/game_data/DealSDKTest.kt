package com.ex2.game_data

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class DealSDKTest {

    @Test
    fun `dealSDK fake mode toggle`() {
        DealSDK.enableFakeMode(true)
        assertTrue(DealSDK.fakeMode)

        DealSDK.enableFakeMode(false)
        assertFalse(DealSDK.fakeMode)
    }

    @Test
    fun `dealSDK fetchDeals returns items`() = runBlocking {
        DealSDK.enableFakeMode(true)
        DealSDK.initialize()
        val items = DealSDK.fetchDeals(10)
        assertTrue(items.isNotEmpty())
    }
}