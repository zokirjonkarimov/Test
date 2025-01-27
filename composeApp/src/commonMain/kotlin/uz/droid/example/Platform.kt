package uz.droid.example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform