package ru.gozerov.firstkmp.presentation.navigation

import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.gozerov.firstkmp.presentation.screens.services.list.ServiceListScreen
import ru.gozerov.firstkmp.presentation.screens.settings.SettingsScreen
import ru.gozerov.firstkmp.presentation.screens.users.details.UserDetailsScreen
import ru.gozerov.firstkmp.presentation.screens.users.list.UserListScreen

fun RootComposeBuilder.navigationGraph() {
    bottomNavigation(Screen.TabsScreen.route, BottomConfiguration()) {
        tab(tabItem = BottomTab.UsersTab) {
            screen(Screen.UserListScreen.route) {
                UserListScreen()
            }
        }
        tab(tabItem = BottomTab.ServicesTab) {
            screen(Screen.ServicesListScreen.route) {
                ServiceListScreen()
            }
        }
        tab(tabItem = BottomTab.SettingsTab) {
            screen(Screen.SettingsScreen.route) {
                SettingsScreen()
            }
        }
    }
    screen(Screen.UserDetailsScreen.route) { id ->
        if (id is Int) {
            UserDetailsScreen(id)
        }
    }
}