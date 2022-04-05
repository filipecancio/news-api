package dev.cancio

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.cancio.routes.categoryRouting
import dev.cancio.routes.configureSerialization
import dev.cancio.routes.homeRouting

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        homeRouting()
        categoryRouting()
        configureSerialization()
    }.start(wait = true)
}