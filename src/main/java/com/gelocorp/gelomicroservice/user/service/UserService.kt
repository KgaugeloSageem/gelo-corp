package com.gelocorp.gelomicroservice.user.service

import com.gelocorp.gelomicroservice.user.model.request.*
import com.gelocorp.gelomicroservice.user.model.ResponseType
import com.gelocorp.gelomicroservice.user.model.User
import com.gelocorp.gelomicroservice.user.model.response.SignInResponse
import com.gelocorp.gelomicroservice.user.model.response.UserRegistrationResponse
import com.gelocorp.gelomicroservice.user.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository){


    fun create(userRegistrationRequest: UserRegistrationRequest): UserRegistrationResponse {
        val response = userRepository.create(userRegistrationRequest)
        return UserRegistrationResponse(ResponseType.SUCCESS,response, "User Regitration Success")
    }

    fun signIn(signInUserRequest: SignInUserRequest): SignInResponse {
        val user = userRepository.getByUsername(signInUserRequest.username)

        val response: SignInResponse = if (user != null){
            if (user.password == signInUserRequest.password){
                SignInResponse(ResponseType.SUCCESS ,data = true, message = "User Successfully Signed In")
            } else {
                SignInResponse(ResponseType.ERROR ,data = false, message = "Password Incorrect")
            }
        }else{
            SignInResponse(ResponseType.ERROR ,data = false, message = "User Does not exist")
        }

        return response
    }

    fun getByUsername(username: String): User? {
       return userRepository.getByUsername(username)
    }

    fun updateName(username: String, userUpdateNameRequest: UserUpdateNameRequest): String {
        return userRepository.updateName(username, userUpdateNameRequest);
    }

    fun updateSurname(username: String, userUpdateSurnameRequest: UserUpdateSurnameRequest): String {
        return userRepository.updateSurname(username, userUpdateSurnameRequest)
    }

    fun updateEmail(username: String, userUpdateEmailRequest: UserUpdateEmailRequest): String {
        return userRepository.updateEmail(username, userUpdateEmailRequest)
    }

    fun updatePassword(username: String, userUpdatePasswordRequest: UserUpdatePasswordRequest): String {
        return userRepository.updatePassword(username, userUpdatePasswordRequest)
    }

    fun deleteByUsername(username: String): String {
        return userRepository.deleteByUsername(username)
    }

}

