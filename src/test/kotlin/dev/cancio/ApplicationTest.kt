package dev.cancio

import io.ktor.http.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*
import dev.cancio.routes.homeRouting

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            homeRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}