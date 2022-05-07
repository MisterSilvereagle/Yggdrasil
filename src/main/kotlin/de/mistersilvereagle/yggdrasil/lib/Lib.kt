package de.mistersilvereagle.yggdrasil.lib

import de.mkammerer.argon2.Argon2Factory
import de.mkammerer.argon2.Argon2Helper

private val argon2 = Argon2Factory.create()

@Suppress("Unused")
fun byteArrayOfInts(vararg ints: Int) = ByteArray(ints.size) { pos -> ints[pos].toByte() }

@Suppress("Unused")
fun generateArgon2Hash(password: ByteArray): String {
    return generateArgon2HashWithByteArray(password)
}

@Suppress("Unused")
fun generateArgon2Hash(password: String): String {
    return generateArgon2HashWithByteArray(password.toByteArray(Charsets.UTF_8))
}

@Suppress("Unused")
fun verifyArgon2Hash(password: ByteArray, hash: String): Boolean {
    return verifyArgon2HashWithByteArray(password, hash )
}

@Suppress("Unused")
fun verifyArgon2Hash(password: String, hash: String): Boolean {
    return verifyArgon2HashWithByteArray(password.toByteArray(Charsets.UTF_8), hash)
}

private fun generateArgon2HashWithByteArray(password: ByteArray): String {
    val iterations = Argon2Helper.findIterations(argon2, 1000, 65536, 1)
    val hash: String

    try {
        hash = argon2.hash(iterations, 65536, 1, password)
    } finally {
        argon2.wipeArray(password)
    }
    return hash
}

private fun verifyArgon2HashWithByteArray(password: ByteArray, hash: String): Boolean {
    val returnValue: Boolean = argon2.verify(hash, password)
    argon2.wipeArray(password)
    return returnValue
}
