package uz.droid.example

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.defaultComponentContext
import uz.droid.example.navigation.RootComponent
import uz.droid.example.navigation.RootComponentImpl
import uz.droid.example.ui.App
import uz.droid.example.ui.background
import uz.droid.example.ui.componet.TextApp
import uz.droid.example.ui.contentPrimary
import uz.droid.example.ui.primaryColor
import uz.droid.example.ui.tertiaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootComponent: RootComponent = RootComponentImpl(defaultComponentContext())
        setContent {
            App(rootComponent)
        }
    }
}

@Preview(widthDp = 1920, heightDp = 1080)
@Composable
private fun CashPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column {
            Row(modifier = Modifier.height(96.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    Modifier
                        .size(96.dp)
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_copy),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.Center),
                        tint = contentPrimary.copy(0.64f)
                    )
                }
                Column(Modifier.padding(16.dp)) {
                    TextApp(text = "Magazin 1", fontSize = 18.sp, lineHeight = 22.sp)
                    TextApp(
                        text = "Срок действия: 2024.05.29",
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        color = contentPrimary.copy(0.64f)
                    )
                }
                Spacer(Modifier.weight(1f))
                Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.End) {
                    TextApp(text = "Magazin 1", fontSize = 18.sp, lineHeight = 22.sp)
                    TextApp(
                        text = "Срок действия: 2024.05.29",
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        color = contentPrimary.copy(0.64f)
                    )
                }
                Row(modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { }
                    .background(Color.White)
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically) {

                    Icon(painter = painterResource(R.drawable.sale_line), contentDescription = null)
                    TextApp(
                        text = "Закрыть смену",
                        modifier = Modifier.padding(start = 12.dp),
                        lineHeight = 22.sp,
                        fontSize = 18.sp
                    )
                }
            }
            Row {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .background(Color.White)
                        .padding(top = 12.dp)
                ) {
                    Item(true, text = "Касса") {}
                    Item(false, text = "Журнал чеков") {}
                    Item(false, text = "Клиенты") {}
                    Item(false, text = "Аналитика") {}
                    Item(false, text = "Каталог товаров") {}
                    Item(false, text = "Склад") {}
                    Item(false, text = "Помощь") {}
                    Item(false, text = "Настройки") {}
                }

                Column(
                    Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp)
                        .background(Color.White, RoundedCornerShape(10.dp))
                        .fillMaxHeight()
                ) {

                }
                Column(
                    Modifier
                        .weight(1f)
                        .padding(end = 16.dp)
                        .background(Color.White, RoundedCornerShape(10.dp))
                        .fillMaxHeight()
                ) {

                }
            }
        }
    }
}

@Composable
fun Item(selected: Boolean, text: String, onClick: () -> Unit) {
    Box {
        Column(
            modifier = Modifier
                .size(96.dp, 88.dp)
                .background(primaryColor.copy(if (selected) 0.2f else 0.0f))
                .clickable { onClick() },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_copy),
                contentDescription = null,
                modifier = Modifier.padding(bottom = 6.dp),
                tint = if (selected) primaryColor else contentPrimary.copy(0.4f)
            )
            TextApp(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = text,
                color = if (selected) contentPrimary else contentPrimary.copy(0.4f),
                lineHeight = 18.sp,
                textAlign = TextAlign.Center
            )
        }
        if (selected)
            Divider(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .height(88.dp)
                    .width(6.dp)
                    .background(primaryColor)
            )
    }
}