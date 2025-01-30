package com.ihyeongjin.user_domain.service

import com.ihyeongjin.user_domain.dto.req.RegisterUserReqDto
import com.ihyeongjin.user_domain.model.User
import com.ihyeongjin.user_domain.repository.UserRepository
import com.ihyeongjin.user_domain.utils.TimeStampUtils
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(private val db: UserRepository) {
    fun findUsers(): List<User> = db.findAll().toList()

    fun findUserById(id: UUID): User? {
        val user = db.findByIdOrNull(id)
        return user
    }

    fun save(registerUserReqDto: RegisterUserReqDto): User {
        val now = TimeStampUtils.currentTimeStamp()
        val hashedPassword = generateHashedPassword(registerUserReqDto.password)
        val userToSave = User(
            email = registerUserReqDto.email,
            hashedPassword = hashedPassword,
            createdAt = now,
            updatedAt = now
        )
        return db.save(userToSave)
    }

    fun generateHashedPassword(password: String): String {
        val encoder = BCryptPasswordEncoder()
        val hashedPassword = encoder.encode(password)
        return hashedPassword
    }
}