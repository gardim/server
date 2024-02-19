package com.example.server.controller

import com.example.server.model.auth.AuthRequest
import com.example.server.model.auth.RegisterRequest
import com.example.server.service.UserService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/auth")
class AuthController(
    private val userService: UserService,
) {

    @ResponseStatus(CREATED)
    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest) = userService.register(registerRequest)

    @ResponseStatus(OK)
    @PostMapping("/authenticate")
    fun authenticate(@RequestBody authenticationRequest: AuthRequest) =
        userService.authenticate(authenticationRequest)
}