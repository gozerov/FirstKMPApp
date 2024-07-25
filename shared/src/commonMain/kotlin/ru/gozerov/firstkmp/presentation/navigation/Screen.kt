package ru.gozerov.firstkmp.presentation.navigation

sealed class Screen(
    val route: String
) {

    data object TabsScreen : Screen("tabsScreen")

    data object UserListScreen : Screen("userListScreen")
    data object UserDetailsScreen : Screen("userDetailsScreen")

    data object ServicesListScreen : Screen("serviceListScreen")

    data object SettingsScreen : Screen("settingsScreen")

}