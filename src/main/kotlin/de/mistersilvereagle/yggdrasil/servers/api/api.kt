package de.mistersilvereagle.yggdrasil.servers.api

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureApi() {
    route("/api") {
        get {
            call.respondText("Hello, world! \r\nApi!")
        }
    }
}