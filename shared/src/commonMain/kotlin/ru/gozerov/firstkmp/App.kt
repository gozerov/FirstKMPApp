package ru.gozerov.firstkmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.alexgladkov.odyssey.compose.RootController
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.gozerov.firstkmp.navigation.Screen

@Composable
internal fun App() {
    val rootController: RootController = LocalRootController.current
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Column {
            Text("Some text")
            Spacer(modifier = Modifier.height(8.dp))
            Text("Some description")
            // AsyncImage("https://i.imgur.com/XwsAIRZ.jpeg", "")
            Button(onClick = {
                rootController.launch(Screen.MyScreen.route)
            }) {
                Text("Navigate")
            }
        }
    }
}