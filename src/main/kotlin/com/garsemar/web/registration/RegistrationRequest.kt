package com.garsemar.web.registration

import lombok.*

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
class RegistrationRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
) {

}