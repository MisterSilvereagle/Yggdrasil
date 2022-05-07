package de.mistersilvereagle.yggdrasil.servers.root

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureRoot() {
    route("/") {
        get {
            call.respondText("Hello, world!")
        }
    }
}