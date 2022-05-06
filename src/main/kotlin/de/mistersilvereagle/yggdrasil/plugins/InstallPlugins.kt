package de.mistersilvereagle.yggdrasil.plugins

import io.ktor.server.plugins.httpsredirect.*
import io.ktor.server.plugins.hsts.*
import io.ktor.server.application.*

fun Application.configurePlugins() {
    install(HttpsRedirect) {
        sslPort = 443
        permanentRedirect = true
    }
    install(HSTS) {
        maxAgeInSeconds = 10
    }
}