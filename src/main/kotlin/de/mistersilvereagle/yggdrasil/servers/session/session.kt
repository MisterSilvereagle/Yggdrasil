package de.mistersilvereagle.yggdrasil.servers.session

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureSession() {
    route("/session") {
        get {
            call.respondText("Hello, world! \r\nSession!")
        }
    }
}