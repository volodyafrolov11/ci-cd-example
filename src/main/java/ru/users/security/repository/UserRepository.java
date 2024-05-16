package ru.users.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.users.security.model.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
