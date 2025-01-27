package uz.droid.example.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import org.jetbrains.compose.ui.tooling.preview.Preview

import uz.droid.example.navigation.RootComponent

@Composable
@Preview
fun App(root: RootComponent) {
    MaterialTheme {
        Children(
            stack = root.stack,
            modifier = Modifier.fillMaxWidth(),
            animation = stackAnimation(fade()),
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.Analytics -> TODO()
                is RootComponent.Child.Cash -> CashScreen()
                is RootComponent.Child.Catalog -> TODO()
                is RootComponent.Child.CheckLog -> TODO()
                is RootComponent.Child.Client -> TODO()
                is RootComponent.Child.Settings -> TODO()
                is RootComponent.Child.Support -> TODO()
                is RootComponent.Child.Warehouse -> TODO()
            }
        }
    }
}