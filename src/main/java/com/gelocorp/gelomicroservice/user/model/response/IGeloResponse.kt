package com.gelocorp.gelomicroservice.user.model.response

import com.gelocorp.gelomicroservice.user.model.ResponseType

interface IGeloResponse{
    val responseType: ResponseType
    val data: Any
    val message: String
}

