package ru.users.security.utils;

import ru.users.security.model.dto.AuthenticationResponse;

public class AuthenticationResponseTestData {

    public static AuthenticationResponse getAuthenticationResponse() {
        return new AuthenticationResponse(
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQG1haWwucnUiLCJpYXQiOjE3MTU4NjcwODgsImV4c" +
                        "CI6MTcxNTg2ODUyOH0.3jTx_sMusI1wbnw2E3oCsFCHYzxYbQuYpyBBsvBWcq8"
        );
    }

}
