package de.mistersilvereagle.yggdrasil.plugins

import de.mistersilvereagle.yggdrasil.routes.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        //customerRouting()
        get("/") {
            call.respondText("Hello, world!")
        }
    }
}
