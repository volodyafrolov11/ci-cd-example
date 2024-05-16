package ru.users.security.utils;

import ru.users.security.model.dto.AuthenticationRequest;

public class AuthenticationRequestTestData {

    public static AuthenticationRequest getAuthenticationRequest() {
        return new AuthenticationRequest(
                "example@mail.ru",
                "12345"
        );
    }

}
