package ru.gozerov.firstkmp.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.gozerov.firstkmp.domain.models.User
import ru.gozerov.firstkmp.domain.repositories.UsersRepository

class GetUsersUseCase(
    private val usersRepository: UsersRepository
) {

    suspend operator fun invoke(): List<User> = withContext(Dispatchers.IO) {
        return@withContext usersRepository.getUsers()
    }

}