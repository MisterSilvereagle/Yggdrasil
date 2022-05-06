package de.mistersilvereagle.yggdrasil.plugins

import de.mistersilvereagle.yggdrasil.routes.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import java.sql.SQLInvalidAuthorizationSpecException
import javax.naming.AuthenticationException

fun Application.configureRouting() {
    routing {
        val paths = arrayOf<String>(
            "/",
            "/session",
            "/account",
            "/auth",
            "/skins",
            "/authserver",
            "/sessionserver",
            "/api",
            "textures"
        //see https://minecraft-api.com/mojang/
        )
        for (path in paths) {
            get(path) {
                call.respondText("Hello, world: "+path)
            }
        }
        customerRouting()
        /*get("/") {
            call.respondText("Hello, world!")
        }*/
        get("/internal-error") {
            throw Exception("Internal Server Error")
        }
        get("/authorization-error") {
            throw SQLInvalidAuthorizationSpecException("Forbidden Error")
        }
        get("/authentication-error") {
            call.respond(HttpStatusCode.Unauthorized)
        }
        get("/authentication-error-2") {
            throw AuthenticationException("Unauthorized Error")
        }
        get("/payment-error") {
            call.respond(HttpStatusCode.PaymentRequired)
        }
        static("/static") {
            resources("files")
        }
    }
}
