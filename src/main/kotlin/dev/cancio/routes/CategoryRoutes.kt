package dev.cancio.routes

import dev.cancio.models.newsStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.categoryRouting() {

    routing {
        get("/category") {
            if (newsStorage.isNotEmpty()) {
                call.respond(newsStorage)
            } else {
                call.respondText("No categories found", status = HttpStatusCode.NotFound)
            }
        }
        get("{category}/{id}") {
            val idParam = call.parameters["id"] ?: return@get call.respondText(
                "parametro id nao encontrado",
                status = HttpStatusCode.BadRequest
            )
            val categoryParam = call.parameters["category"] ?: return@get call.respondText(
                "parametro category nao encontrado",
                status = HttpStatusCode.BadRequest
            )
            val category = newsStorage.find { it.name == categoryParam } ?: return@get call.respondText(
                "Noticia nao encontrada",
                status = HttpStatusCode.NotFound
            )
            val news = category.content.find { it.id == idParam } ?: return@get call.respondText(
                "Noticia nao encontrada",
                status = HttpStatusCode.NotFound
            )
            call.respond(news)
        }
        post {

        }
        delete("{id}") {

        }
    }
}