package uz.droid.example.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import uz.droid.example.presenter.impl.CatalogComponentImpl
import uz.droid.example.presenter.AnalyticsComponent
import uz.droid.example.presenter.CashComponent
import uz.droid.example.presenter.CatalogComponent
import uz.droid.example.presenter.CheckLogComponent
import uz.droid.example.presenter.ClientComponent
import uz.droid.example.presenter.SettingsComponent
import uz.droid.example.presenter.SupportComponent
import uz.droid.example.presenter.WarehouseComponent
import uz.droid.example.presenter.impl.AnalyticsComponentImpl
import uz.droid.example.presenter.impl.CashComponentImpl
import uz.droid.example.presenter.impl.CheckLogComponentImpl
import uz.droid.example.presenter.impl.ClientComponentImpl
import uz.droid.example.presenter.impl.SettingsComponentImpl
import uz.droid.example.presenter.impl.SupportComponentImpl
import uz.droid.example.presenter.impl.WarehouseComponentImpl

class RootComponentImpl(
    private val componentContext: ComponentContext,
) : ComponentContext by componentContext, RootComponent {

    private val navigation = StackNavigation<RootComponent.Config>()
    override val stack : Value<ChildStack<*, RootComponent.Child>>
     = childStack(
        source = navigation,
        serializer = RootComponent.Config.serializer(),
        initialConfiguration = RootComponent.Config.Cash,
        handleBackButton = true,
        childFactory = ::child,
    )

    fun child(config: RootComponent.Config, componentContext: ComponentContext): RootComponent.Child {
        return when(config){
            RootComponent.Config.Analytics -> {
                val presenter : AnalyticsComponent = AnalyticsComponentImpl(componentContext)
                RootComponent.Child.Analytics(presenter)
            }
            RootComponent.Config.Cash -> {
                val presenter : CashComponent = CashComponentImpl(componentContext)
                RootComponent.Child.Cash(presenter)
            }
            RootComponent.Config.Catalog -> {
                val presenter : CatalogComponent = CatalogComponentImpl(componentContext)
                RootComponent.Child.Catalog(presenter)
            }
            RootComponent.Config.CheckLog -> {
                val presenter : CheckLogComponent = CheckLogComponentImpl(componentContext)
                RootComponent.Child.CheckLog(presenter)
            }
            RootComponent.Config.Client -> {
                val presenter : ClientComponent = ClientComponentImpl(componentContext)
                RootComponent.Child.Client(presenter)
            }
            RootComponent.Config.Settings -> {
                val presenter : SettingsComponent = SettingsComponentImpl(componentContext)
                RootComponent.Child.Settings(presenter)
            }
            RootComponent.Config.Support -> {
                val presenter : SupportComponent = SupportComponentImpl(componentContext)
                RootComponent.Child.Support(presenter)
            }
            RootComponent.Config.Warehouse -> {
                val presenter : WarehouseComponent = WarehouseComponentImpl(componentContext)
                RootComponent.Child.Warehouse(presenter)
            }
        }
    }
}

