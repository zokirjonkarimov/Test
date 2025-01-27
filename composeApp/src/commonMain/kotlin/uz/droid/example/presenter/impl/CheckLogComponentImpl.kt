package uz.droid.example.presenter.impl

import com.arkivanov.decompose.ComponentContext
import uz.droid.example.presenter.CheckLogComponent

class CheckLogComponentImpl(componentContext: ComponentContext) : CheckLogComponent, ComponentContext by componentContext {

}
