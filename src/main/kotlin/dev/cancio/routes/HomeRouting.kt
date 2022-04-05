package dev.cancio.routes

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.homeRouting() {

    routing {
        get("/") {
            call.respond(endpointsList)
        }
    }
}

val endpointsList = listOf(
    mapOf("category" to "http://localhost:8080/category")
)
