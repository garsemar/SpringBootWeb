package com.garsemar.web.appuser

import lombok.AllArgsConstructor
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
@AllArgsConstructor
class AppUserService(val appUserRepository: AppUserRepository): UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String?): UserDetails? {
        return appUserRepository.findByEmail(email)
    }
}