package com.gelocorp.gelomicroservice.user.controller

import com.gelocorp.gelomicroservice.user.model.request.*
import com.gelocorp.gelomicroservice.user.model.User
import com.gelocorp.gelomicroservice.user.model.response.UserRegistrationResponse
import com.gelocorp.gelomicroservice.user.service.UserService
import com.gelocorp.gelomicroservice.user.model.request.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ExecutionException

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService)   {

    @Throws(InterruptedException::class, ExecutionException::class)
    @PostMapping("/register")
    fun createUser( @RequestBody userRegistrationRequest: UserRegistrationRequest): UserRegistrationResponse {
        return userService.create(userRegistrationRequest)
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    @GetMapping("/get/{username}")
    fun getUser( @PathVariable username: String): User? {
        return userService.getByUsername(username)
    }

    @PutMapping("/update/name/{username}")
    fun updateName( @PathVariable username: String, @RequestBody userUpdateNameRequest: UserUpdateNameRequest): String {
        return userService.updateName(username, userUpdateNameRequest)
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    @PutMapping("/update/surname/{username}")
    fun updateSurname( @PathVariable username: String, userUpdateSurnameRequest: UserUpdateSurnameRequest): String {
        return userService.updateSurname(username, userUpdateSurnameRequest)
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    @PutMapping("/update/email/{username}")
    fun updateEmail( @PathVariable username: String, userUpdateEmailRequest: UserUpdateEmailRequest): String {
        return userService.updateEmail(username, userUpdateEmailRequest)
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    @PutMapping("/update/password/{username}")
    fun updatePassword( @PathVariable username: String, userUpdatePasswordRequest: UserUpdatePasswordRequest): String {
        return userService.updatePassword(username, userUpdatePasswordRequest)
    }


    @Throws(InterruptedException::class, ExecutionException::class)
    @DeleteMapping("/delete/{username}")
    fun deleteUser( @PathVariable username: String): String {
        return userService.deleteByUsername(username)
    }

    @GetMapping("/test")
    fun test():ResponseEntity<String>{
        return ResponseEntity.ok("Test get enpoint is running")
    }

}