package de.mistersilvereagle.yggdrasil.plugins

import de.mistersilvereagle.yggdrasil.routes.*

import de.mistersilvereagle.yggdrasil.servers.root.configureRoot
import de.mistersilvereagle.yggdrasil.servers.session.configureSession
import de.mistersilvereagle.yggdrasil.servers.account.configureAccount
import de.mistersilvereagle.yggdrasil.servers.auth.configureAuth
import de.mistersilvereagle.yggdrasil.servers.skins.configureSkins
import de.mistersilvereagle.yggdrasil.servers.authserver.configureAuthserver
import de.mistersilvereagle.yggdrasil.servers.sessionserver.configureSessionserver
import de.mistersilvereagle.yggdrasil.servers.api.configureApi
import de.mistersilvereagle.yggdrasil.servers.textures.configureTextures

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import java.sql.SQLInvalidAuthorizationSpecException
import javax.naming.AuthenticationException

fun Application.configureRouting() {
    routing {

        /**
         * Configure the Routings for each server [de.mistersilvereagle.yggdrasil.servers.*]
         */

        configureRoot()
        configureSession()
        configureAccount()
        configureAuth()
        configureSkins()
        configureAuthserver()
        configureSessionserver()
        configureApi()
        configureTextures()
        
        customerRouting()
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
        static("/") {
            resources("files")
        }
    }
}
