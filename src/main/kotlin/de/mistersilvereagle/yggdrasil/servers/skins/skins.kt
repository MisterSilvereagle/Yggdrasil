package de.mistersilvereagle.yggdrasil.servers.skins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureSkins() {
    route("/skins") {
        get {
            call.respondText("Hello, world! \r\nSkins!")
        }
    }
}