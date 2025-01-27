package uz.droid.example

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import uz.droid.example.navigation.RootComponent
import uz.droid.example.navigation.RootComponentImpl

fun main() = application {
    val lifecycle = remember { LifecycleRegistry() }
    val root: RootComponent = remember {
        runOnUiThread {
            RootComponentImpl(
                componentContext = DefaultComponentContext(lifecycle = lifecycle),
            )
        }
    }
    val windowState = rememberWindowState()
    LifecycleController(lifecycle, windowState)
    Window(
        onCloseRequest = ::exitApplication,
        title = "Test",
        state = windowState,
    ) {
        App(root)
    }
}
