package com.ex2.game_data.contract

import com.ex2.game_data.base.TestUtils
import com.ex2.game_data.nw.api.DealsApiImpl
import io.ktor.client.HttpClient
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class GameDealTest {

    @Test
    fun `test read Deals JSON`() = runBlocking {
        val fakeClient: HttpClient = TestUtils.provideFakeClient("deals.json")
        val list = DealsApiImpl(fakeClient).fetchDeals()
        assert(list.isNotEmpty())
    }

    @Test
    fun `test fetch Deal Info OK response`() = runBlocking {
        val fakeClient: HttpClient = TestUtils.provideFakeClient("deal_info.json")
        val data = DealsApiImpl(fakeClient).fetchDeal("dummy")
        assertNotNull(data)
    }
    
    @Test
    fun `test fetch Deal Info non-OK response`() = runBlocking {
        val fakeClient: HttpClient =
            TestUtils.provideFakeClient("blank.txt", statusCode = HttpStatusCode.BadRequest)
        val data = DealsApiImpl(fakeClient).fetchDeal("dummy")
        assertNull(data)
    }
}