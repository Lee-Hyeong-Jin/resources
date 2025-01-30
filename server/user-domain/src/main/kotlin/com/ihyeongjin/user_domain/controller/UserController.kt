package com.ihyeongjin.user_domain.controller

import com.ihyeongjin.user_domain.dto.req.RegisterUserReqDto
import com.ihyeongjin.user_domain.model.User
import com.ihyeongjin.user_domain.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {
    @GetMapping
    fun getAllUsers() = service.findUsers()

    @PostMapping
    fun registerUser(@RequestBody registerUserReqDto: RegisterUserReqDto): ResponseEntity<User> {
        val savedUser = service.save(registerUserReqDto)
        return ResponseEntity.created(URI("/${savedUser.id}")).body(savedUser)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: UUID): ResponseEntity<User> = service.findUserById(id).toResponseEntity()

    private fun User?.toResponseEntity(): ResponseEntity<User> = this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}