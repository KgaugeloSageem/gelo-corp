package com.gelocorp.gelomicroservice.user.model.response

import com.gelocorp.gelomicroservice.user.model.ResponseType

data class UserRegistrationResponse(override val responseType: ResponseType, override val data: Any, override val message: String):
    IGeloResponse