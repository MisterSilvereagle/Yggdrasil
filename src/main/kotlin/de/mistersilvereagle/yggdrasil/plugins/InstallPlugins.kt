package de.mistersilvereagle.yggdrasil.plugins

import io.ktor.http.*
import io.ktor.server.plugins.httpsredirect.*
import io.ktor.server.plugins.hsts.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import java.sql.SQLInvalidAuthorizationSpecException
import javax.naming.AuthenticationException

fun Application.configurePlugins() {
    install(HttpsRedirect) {
        sslPort = 443
        permanentRedirect = true
    }
    install(HSTS) {
        maxAgeInSeconds = 10
    }
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            if(cause is SQLInvalidAuthorizationSpecException) {
                call.respondText(text = "403: $cause" , status = HttpStatusCode.Forbidden)
            } else if(cause is AuthenticationException) {
                call.respondText(text = "401: $cause" , status = HttpStatusCode.Unauthorized)
            } else {
                call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
            }
        }
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondText(text = "404: Page Not Found", status = status)
        }
        statusFile(HttpStatusCode.Unauthorized, HttpStatusCode.PaymentRequired, filePattern = "files/error#.html")
    }
}