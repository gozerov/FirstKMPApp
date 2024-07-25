package ru.gozerov.firstkmp.presentation.screens.users.list.models

import ru.gozerov.firstkmp.domain.models.User

sealed interface UsersListViewState {

    object Empty: UsersListViewState

    class LoadedUsers(
        val users: List<User>
    ): UsersListViewState

    class Error(
        val message: String
    ): UsersListViewState

}