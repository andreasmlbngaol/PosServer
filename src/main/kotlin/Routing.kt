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

        route("/stocks") {
            get {
                val id = call.parameters["id"]?.toIntOrNull()
                val code = call.parameters["code"]

                if(id != null) {
                    call.respond(PosRepository.getItemById(id) ?: HttpStatusCode.NotFound)
                } else if (code != null) {
                    call.respond(PosRepository.getItemByCode(code) ?: HttpStatusCode.NotFound)
                } else {
                    call.respond(PosRepository.getAllItems())
                }
            }
        }

        route("/users") {
            get {
                call.parameters["uid"]?.let { uid ->
                    call.respond(PosRepository.getUser(uid) ?: HttpStatusCode.NotFound)
                } ?: call.respond(PosRepository.getAllUsers())
            }
        }

        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
