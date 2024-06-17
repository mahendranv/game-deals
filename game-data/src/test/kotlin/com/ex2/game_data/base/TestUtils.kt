package com.ex2.game_data.base

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.ByteReadChannel
import kotlinx.serialization.json.Json

object TestUtils {

    fun provideFakeClient(
        fileName: String, statusCode: HttpStatusCode = HttpStatusCode.OK
    ): HttpClient {
        val mockEngine = MockEngine {
            val content = javaClass.classLoader.getResource(fileName)!!.readText(Charsets.UTF_8)
            respond(
                content = ByteReadChannel(content),
                status = statusCode,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        return HttpClient(mockEngine) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = false
                })
            }
        }
    }
}