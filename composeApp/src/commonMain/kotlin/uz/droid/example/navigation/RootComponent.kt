package uz.droid.example.navigation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import uz.droid.example.presenter.AnalyticsComponent
import uz.droid.example.presenter.CashComponent
import uz.droid.example.presenter.CatalogComponent
import uz.droid.example.presenter.CheckLogComponent
import uz.droid.example.presenter.ClientComponent
import uz.droid.example.presenter.SettingsComponent
import uz.droid.example.presenter.SupportComponent
import uz.droid.example.presenter.WarehouseComponent

interface RootComponent {

    sealed interface Child {
        class Cash(val component: CashComponent) : Child
        class CheckLog(val component: CheckLogComponent) : Child
        class Client(val component: ClientComponent) : Child
        class Analytics(val component: AnalyticsComponent) : Child
        class Catalog(val component: CatalogComponent) : Child
        class Warehouse(val component: WarehouseComponent) : Child
        class Settings(val component: SettingsComponent) : Child
        class Support(val component: SupportComponent) : Child
    }

    @Serializable
    sealed interface Config {
        @Serializable
        data object Cash : Config

        @Serializable
        data object CheckLog : Config

        @Serializable
        data object Client : Config

        @Serializable
        data object Analytics : Config

        @Serializable
        data object Catalog : Config

        @Serializable
        data object Warehouse : Config

        @Serializable
        data object Settings : Config

        @Serializable
        data object Support : Config
    }

    val stack: Value<ChildStack<*, Child>>
}