package de.mistersilvereagle.yggdrasil.servers.account

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureAccount() {
    route("/account") {
        get {
            call.respondText("Hello, world! \r\nAccount!")
        }
    }
}