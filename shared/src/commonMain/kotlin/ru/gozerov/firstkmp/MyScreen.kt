package ru.gozerov.firstkmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun MyScreen() {
    val rootController = LocalRootController.current
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
    ) {
        Button(onClick = {
            rootController.popBackStack()
        }) {
            Image(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
        }
        Box(modifier = Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center) {
            Text("MyScreen", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
    }
}