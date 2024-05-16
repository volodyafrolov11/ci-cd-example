package ru.users.security.utils;

import ru.users.security.model.dto.RegistrationRequest;

public class RegistrationRequestTestData {

    public static RegistrationRequest getRegistrationRequest() {
        return new RegistrationRequest(
                "firstname",
                "lastname",
                "example@mail.ru",
                "12345"
        );
    }

}
