package de.mistersilvereagle.yggdrasil

import de.mistersilvereagle.yggdrasil.plugins.*

import io.ktor.server.application.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configurePlugins()
    configureRouting()
    configureSerialization()
    configureTemplating()
}