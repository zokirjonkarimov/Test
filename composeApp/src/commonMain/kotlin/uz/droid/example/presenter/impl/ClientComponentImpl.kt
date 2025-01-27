package uz.droid.example.presenter.impl

import com.arkivanov.decompose.ComponentContext
import uz.droid.example.presenter.ClientComponent

class ClientComponentImpl(componentContext: ComponentContext) : ClientComponent, ComponentContext by componentContext {

}
