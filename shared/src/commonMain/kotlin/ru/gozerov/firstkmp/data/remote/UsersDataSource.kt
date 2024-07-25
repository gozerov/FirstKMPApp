package ru.gozerov.firstkmp.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.gozerov.firstkmp.data.models.UserDTO

class UsersDataSource(
    private val ktorService: KtorService
) {

    suspend fun getUsers(): List<UserDTO> {
        return ktorService.client.get("${KtorService.BASE_URL}/users").body()
    }

}