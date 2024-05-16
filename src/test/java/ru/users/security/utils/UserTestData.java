package ru.users.security.utils;

import ru.users.security.model.entities.Role;
import ru.users.security.model.entities.User;

public class UserTestData {

    public static User getUserTransient() {
        return new User(
                null,
                "firstname",
                "lastname",
                "email@example.ru",
                "12345",
                Role.USER
        );
    }

    public static User getUserPersisted() {
        return new User(
                1,
                "firstname",
                "lastname",
                "email@example.ru",
                "12345",
                Role.USER
        );
    }

}
