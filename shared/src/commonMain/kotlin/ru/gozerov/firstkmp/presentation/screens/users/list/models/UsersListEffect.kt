package ru.gozerov.firstkmp.presentation.screens.users.list.models

sealed interface UsersListEffect {

    object LoadUsers : UsersListEffect

}