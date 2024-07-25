package ru.gozerov.firstkmp.data.models

import ru.gozerov.firstkmp.domain.models.User

fun UserDTO.toUser() = User(id, name)