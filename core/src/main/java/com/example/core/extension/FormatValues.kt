package com.example.core.extension

import java.security.MessageDigest

fun String.getUniqueValueFormString(): String {

    val md = MessageDigest.getInstance("SHA-256")
    val hashBytes = md.digest(this.toByteArray())
    var result = 0
    for (i in 0 until 4) {
        result = result shl 8 or (hashBytes[i].toInt() and 0xFF)
    }

    return result.toString()

}

