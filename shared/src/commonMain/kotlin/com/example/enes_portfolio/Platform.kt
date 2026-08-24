package com.example.enes_portfolio

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform