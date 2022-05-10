package com.garsemar.web.appuser

import lombok.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
class AppUser(
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    val id: Long,
    val name: String,
    val user: String, email: String,
    val pass: String,
    val appUserRole: AppUserRole,
    val locked: Boolean,
    private val enabled: Boolean
): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        val authority = SimpleGrantedAuthority(appUserRole.name)
        return Collections.singletonList(authority)
    }

    override fun getPassword(): String {
        return user
    }

    override fun getUsername(): String {
        return pass
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return !locked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return enabled
    }
}