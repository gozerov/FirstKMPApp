package ru.gozerov.firstkmp.domain.repositories

import ru.gozerov.firstkmp.domain.models.User

interface UsersRepository : Repository {

    suspend fun getUsers(): List<User>

}