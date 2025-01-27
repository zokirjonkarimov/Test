package uz.droid.example.presenter.impl

import com.arkivanov.decompose.ComponentContext
import uz.droid.example.presenter.SupportComponent

class SupportComponentImpl(componentContext: ComponentContext) : SupportComponent, ComponentContext by componentContext {

}
