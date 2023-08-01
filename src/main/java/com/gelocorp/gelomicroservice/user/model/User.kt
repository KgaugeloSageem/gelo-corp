package com.gelocorp.gelomicroservice.user.model

import com.google.cloud.firestore.QueryDocumentSnapshot
import com.google.cloud.firestore.annotation.DocumentId

class User(@DocumentId
           val username: String,
           val name: String?,
           val surname: String?,
           val password: String?,
           val email: String?){
    companion object{
        fun QueryDocumentSnapshot.toUser(): User {
            return User(
                    username = id,
                    name = getString("name"),
                    surname = getString("surname"),
                    email = getString("email"),
                    password = getString("password")
            )
        }
    }
}


