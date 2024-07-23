package ru.gozerov.firstkmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.gozerov.firstkmp.navigation.navigationGraph

fun MainViewController(): UIViewController = ComposeUIViewController {
    SafeArea {
        val configuration = OdysseyConfiguration(backgroundColor = Color.White)

        setNavigationContent(configuration) {
            navigationGraph()
        }
    }
}

@Composable
internal fun SafeArea(
    content: @Composable () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.height(50.dp))
        content.invoke()
    }
}