package uz.droid.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import test.composeapp.generated.resources.Res
import test.composeapp.generated.resources.compose_multiplatform
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
                is RootComponent.Child.Cash -> TODO()
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