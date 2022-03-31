package dev.cancio.routes

import dev.cancio.models.newsStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.categoryRouting() {

    routing {
        get("/category") {
            if (newsStorage.isNotEmpty()){
                call.respond(newsStorage)
            }else{
                call.respondText("No categories found", status = HttpStatusCode.NotFound)
            }
        }
        get("{id}") {

        }
        post {

        }
        delete("{id}") {

        }
    }
}