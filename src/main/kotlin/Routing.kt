package com.dabelyu

import com.dabelyu.repository.PosRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello from Caritas KAM!")
        }

        get("/lisa") {
            call.respondText("I love you!")
        }

        route("/items") {

            get {
                call.respond(PosRepository.getAllItems())
            }

            get("/{code}") {
                call.parameters["code"]?.toIntOrNull()?.let { code ->
                    call.respond(PosRepository.getItemByCode(code) ?: HttpStatusCode.NotFound)
                } ?: call.respond(HttpStatusCode.NotFound, "Item not found")
            }
        }

        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
