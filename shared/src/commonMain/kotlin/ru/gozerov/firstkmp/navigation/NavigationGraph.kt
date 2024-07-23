package ru.gozerov.firstkmp.navigation

import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.gozerov.firstkmp.App
import ru.gozerov.firstkmp.MyScreen

fun RootComposeBuilder.navigationGraph() {
    screen(Screen.MainScreen.route) {
        App()
    }
    screen(Screen.MyScreen.route) {
        MyScreen()
    }
}