package uz.droid.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import uz.droid.example.navigation.RootComponent
import uz.droid.example.navigation.RootComponentImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootComponent : RootComponent = RootComponentImpl(defaultComponentContext())
        setContent {
            App(rootComponent)
        }
    }
}