# Game Deals

Game deals is an app built on top of [CheapShark](https://apidocs.cheapshark.com/#e3d7f1f0-f7a4-b36a-587a-6514a40f4d88) API to list games and deals.

## Response testing
We're using KTor + Kotlinx serialization + Kotlin DateTime for network layer (just to ensure the core module is KMP proof). Though CheapShark API has no restriction, we should be considerate on the usage. For that purpose, we'll use heavy caching in prod app. 

For development purpose, the data deserialization and mock response from the API doc to fix on the data types and custom Serializers (Date, Boolean). KTor has a handy option to plug in mock engine to use static content for testing purpose. Dependency details as follows.

```toml
ktor-client-core = { module = "io.ktor:ktor-client-core", version.ref = "ktor" }
ktor-serialization-kotlinx-json = { module = "io.ktor:ktor-serialization-kotlinx-json", version.ref = "ktor" }
ktor-client-content-negotiation = { module = "io.ktor:ktor-client-content-negotiation", version.ref = "ktor" }

// CIO engine
ktor-client-cio = { module = "io.ktor:ktor-client-cio", version.ref = "ktor" }

// Mock client
ktor-client-mock = { module = "io.ktor:ktor-client-mock", version.ref = "ktor" }
```

```groovy
// game-data/build.gradle
testImplementation(libs.ktor.client.mock)
```

### Adding Samples
Create plain text files under test/resources directory to use with Unit tests. The sample response can be picked from the API page of cheapshark or use CURL and pipe the response to a file.

```
├── build.gradle.kts
├── sample
└── src
    ├── main
    │     └── java
    └── test
        ├── kotlin
        │└── com
        │    └── ex2
        │        └── game_data
        │            ├── base
        │            │     └── TestUtils.kt
        │            └── contract
        │                └── GameDealTest.kt
        └── resources
            ├── blank.txt
            ├── deal_info.json
            └── deals.json
```

### Reading the resource file
We can use the class loader to read the sample file from resource dir. Below snippet creates a Fake HttpClient and reads the file and stream it in response. For our usecase, we've provided two customizations - the content JSON file and status code. And we're not using the request param to assert incoming request as new engine will be used per test.

```kotlin
 fun provideFakeClient(
        fileName: String, 
        statusCode: HttpStatusCode = HttpStatusCode.OK
    ): HttpClient {
        val mockEngine = MockEngine { request -> // it is possible to read incoming request and create custom response.
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
```

### Consuming the response
We can call the fake client factory to get a new one - passing down the sample response content and optional Status Code. The below tests asserts whether the content is deserialized successfully and the error case where status code is not-OK. More cases can be added like optional fields / null values etc.

This approach is particularly useful to test the custom deserializers in action. 
1. Can be used to verify the underlying serialization framework's ability to convert string to other primitives. In this case, the string to Int / Float conversion is smooth without mentioning any additonal property in the annotations.
2. How the collections are handled
3. Nested objects handling
4. Custom deserializer

```kotlin
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
```