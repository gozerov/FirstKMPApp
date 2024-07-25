package ru.gozerov.firstkmp.presentation.screens.users.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun UserDetailsScreen(
    id: Int
) {
    Text("Username is $id")
}