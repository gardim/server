package com.example.server.service

import com.example.server.entity.UserEntity
import com.example.server.exception.RegisteredException
import com.example.server.model.auth.AuthRequest
import com.example.server.model.auth.AuthResponse
import com.example.server.model.auth.RegisterRequest
import com.example.server.repository.UserRepository
import com.example.server.security.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) {
    fun register(registerRequest: RegisterRequest): AuthResponse {

        if (userRepository.findByUsernameOrEmail(registerRequest.username, registerRequest.email) != null) {
            throw RegisteredException()
        }

        val user = UserEntity(
            email = registerRequest.email,
            username = registerRequest.username,
            password = passwordEncoder.encode(registerRequest.password)
        )

        userRepository.save(user)

        val token = jwtService.generateToken(user)

        return AuthResponse(token)
    }

    fun authenticate(authenticationRequest: AuthRequest): AuthResponse {

        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authenticationRequest.username,
                authenticationRequest.password
            )
        )

        val user = userRepository.findByUsername(authenticationRequest.username)

        return AuthResponse(jwtService.generateToken(user!!))
    }
}