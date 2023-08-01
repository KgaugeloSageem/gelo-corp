package com.gelocorp.gelomicroservice.user.repository

import com.gelocorp.gelomicroservice.user.model.request.*
import com.gelocorp.gelomicroservice.user.model.User
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {

    fun create(userRegistrationRequest: UserRegistrationRequest): String

    fun getByUsername(username: String): User?

    fun deleteByUsername(username: String): String

    fun updatePassword(username: String, userUpdateNameRequest: UserUpdatePasswordRequest): String

    fun updateEmail(username: String, userUpdateNameRequest: UserUpdateEmailRequest): String

    fun updateSurname(username: String, userUpdateNameRequest: UserUpdateSurnameRequest): String

    fun updateName(username: String, userUpdateNameRequest: UserUpdateNameRequest): String
}