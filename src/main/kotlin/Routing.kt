package com.dabelyu

import com.dabelyu.repository.UserRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(val name: String, val email: String)

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello from Caritas KAM!")
        }

        get("/lisa") {
            call.respondText("I love you!")
        }

        route("/users") {

            get {
                call.respond(UserRepository.getAllUsers())
            }

            get("/{id}") {
                call.parameters["id"]?.toIntOrNull()?.let { id ->
                    call.respond(UserRepository.getUserById(id) ?: HttpStatusCode.NotFound)
                } ?: call.respond(HttpStatusCode.NotFound, "User not found")
            }
        }

        post("/users") {
            val request = call.receive<UserRequest>()
            val newUser = UserRepository.addUser(request.name, request.email)
            if (newUser != null) {
                call.respond(newUser)
            } else {
                call.respondText("Failed to add user")
            }
        }

        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
