package ru.gozerov.firstkmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.gozerov.firstkmp.navigation.navigationGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val configuration = OdysseyConfiguration(canvas = this)

            setNavigationContent(configuration) {
                navigationGraph()
            }
        }
    }
}
