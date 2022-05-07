package de.mistersilvereagle.yggdrasil.servers.textures

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.configureTextures() {
    route("/textures") {
        get {
            call.respondText("Hello, world! \r\nTextures")
        }
    }
}