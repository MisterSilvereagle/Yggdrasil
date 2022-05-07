package de.mistersilvereagle.yggdrasil.servers.sessionserver

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureSessionserver() {
    route("/sessionserver") {
        get {
            call.respondText("Hello, world! \r\nSessionserver!")
        }
    }
}