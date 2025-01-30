package com.ihyeongjin.user_domain.repository

import com.ihyeongjin.user_domain.model.User
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserRepository : CrudRepository<User, UUID>