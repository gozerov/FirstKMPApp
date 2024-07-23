package ru.gozerov.firstkmp.navigation

sealed class Screen(
    val route: String
) {

    data object MainScreen: Screen("mainScreen")
    data object MyScreen: Screen("myScreen")

}