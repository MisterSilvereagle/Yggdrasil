package de.mistersilvereagle.yggdrasil.servers.authserver

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureAuthserver() {
    route("/authserver") {
        get {
            call.respondText("Hello, world! \r\nAuthserver!")
        }
    }
}