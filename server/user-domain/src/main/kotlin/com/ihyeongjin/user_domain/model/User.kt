package com.ihyeongjin.user_domain.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Timestamp
import java.util.UUID

@Table("users")
data class User(
    @Id
    val id: UUID? = null,

    val email: String,
    val hashedPassword: String,
    val emailVerifiedAt: Timestamp? = null,

    @Column("created_at")
    val createdAt: Timestamp? = null,

    @Column("updated_at")
    val updatedAt: Timestamp? = null
)
