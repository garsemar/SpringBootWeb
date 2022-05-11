package com.garsemar.web.registration

import lombok.AllArgsConstructor
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties.Registration
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["api/v1/registration"])
@AllArgsConstructor
class RegistrationController(val registrationService: RegistrationService) {
    fun register(@RequestBody request: RegistrationRequest): String{
        return registrationService.register(request)
    }
}