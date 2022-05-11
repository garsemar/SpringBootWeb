package com.garsemar.web.appuser

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
interface AppUserRepository {
    fun findByEmail(email: String?): AppUser
}