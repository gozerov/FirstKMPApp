package ru.gozerov.firstkmp.presentation.navigation

import androidx.compose.runtime.Composable
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabItem

sealed interface BottomTab {

    data object UsersTab : TabItem(), BottomTab {
        override val configuration: TabConfiguration
            @Composable
            get() {
                return TabConfiguration(
                    title = "Users",
                )
            }
    }

    data object ServicesTab : TabItem(), BottomTab {
        override val configuration: TabConfiguration
            @Composable
            get() {
                return TabConfiguration(
                    title = "Services",
                )
            }
    }

    data object SettingsTab : TabItem(), BottomTab {
        override val configuration: TabConfiguration
            @Composable
            get() {
                return TabConfiguration(
                    title = "Settings",
                )
            }
    }

}