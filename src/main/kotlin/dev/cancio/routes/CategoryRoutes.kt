package dev.cancio.routes

import dev.cancio.models.News
import dev.cancio.models.newsStorage
import dev.cancio.models.request.PostCategoryRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
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
            val category = newsStorage.find { it.name.type == categoryParam } ?: return@get call.respondText(
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
            val request = call.receive<PostCategoryRequest>()
            val content = newsStorage.find { it.name == request.category }?.content?.add(request.news)
            if (content == true) {
                call.respondText(
                    "Customer stored correctly",
                    status = HttpStatusCode.Created
                )
            } else {
                call.respondText(
                    "parametro category nao encontrado",
                    status = HttpStatusCode.BadRequest
                )
            }
        }
        put("{category}/{id}") {
            val request = call.receive<News>()
            val idParam = call.parameters["id"] ?: return@put call.respondText(
                "parametro id nao encontrado",
                status = HttpStatusCode.BadRequest
            )
            val categoryParam = call.parameters["category"] ?: return@put call.respondText(
                "parametro category nao encontrado",
                status = HttpStatusCode.BadRequest
            )
            val category = newsStorage.find { it.name.type == categoryParam }?.content?.find { it.id == idParam } ?.apply {
                id = request.id
                date = request.date
                title = request.title
                urlName = request.urlName
            }
            call.respond(request)
        }
        delete("{category}/{id}") {
            val idParam = call.parameters["id"] ?: return@delete call.respondText(
                "parametro id nao encontrado",
                status = HttpStatusCode.BadRequest
            )
            val categoryParam = call.parameters["category"] ?: return@delete call.respondText(
                "parametro category nao encontrado",
                status = HttpStatusCode.BadRequest
            )
            val category = newsStorage.find { it.name.type == categoryParam }?.content?.removeIf { it.id == idParam }
            if (category == true) {
                call.respondText("Customer removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }

        }
    }
}