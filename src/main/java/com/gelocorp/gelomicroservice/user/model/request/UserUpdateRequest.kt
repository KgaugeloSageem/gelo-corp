package com.gelocorp.gelomicroservice.user.model.request

import com.google.cloud.firestore.annotation.DocumentId

class UserUpdateNameRequest(
        val newName: String
)

class UserUpdateSurnameRequest(
        val newSurname: String
)

class UserUpdatePasswordRequest(
        val newPassword: String
)

class UserUpdateEmailRequest(
        val newEmail: String
)