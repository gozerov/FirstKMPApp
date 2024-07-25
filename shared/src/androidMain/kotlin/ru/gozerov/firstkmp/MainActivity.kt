package ru.gozerov.firstkmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import ru.gozerov.firstkmp.presentation.navigation.navigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val configuration = OdysseyConfiguration(
                canvas = this,
                displayType = DisplayType.EdgeToEdge,
                backgroundColor = Color.White
            )

            setNavigationContent(configuration) {
                navigationGraph()
            }
        }
    }
}
