package com.gelocorp.gelomicroservice.user.model.request

import com.google.cloud.firestore.annotation.DocumentId

class UserRegistrationRequest(@DocumentId val username: String,val name: String,val surname: String, val password: String, val email: String)