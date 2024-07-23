package ru.gozerov.firstkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform