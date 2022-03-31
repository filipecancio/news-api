package dev.cancio

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.cancio.plugins.*
import dev.cancio.routes.categoryRouting
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        configureRouting()
        categoryRouting()
        configureSerialization()
    }.start(wait = true)
}