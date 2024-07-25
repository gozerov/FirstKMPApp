package ru.gozerov.firstkmp.data.models

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val id: Int,
    val name: String,
)
