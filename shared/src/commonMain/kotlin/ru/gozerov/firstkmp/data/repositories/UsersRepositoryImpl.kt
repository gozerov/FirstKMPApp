package ru.gozerov.firstkmp.data.repositories

import ru.gozerov.firstkmp.data.models.toUser
import ru.gozerov.firstkmp.data.remote.UsersDataSource
import ru.gozerov.firstkmp.domain.models.User
import ru.gozerov.firstkmp.domain.repositories.UsersRepository

class UsersRepositoryImpl(
    private val usersDataSource: UsersDataSource
) : UsersRepository {

    override suspend fun getUsers(): List<User> {
        return usersDataSource.getUsers().map { dto -> dto.toUser() }
    }

}