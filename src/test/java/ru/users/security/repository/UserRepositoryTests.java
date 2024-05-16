package ru.users.security.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.users.security.model.entities.User;
import ru.users.security.utils.UserTestData;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("Test save user functionality")
    public void givenUserToSave_whenSave_thenUserIsSavedInDb() {
        // given
        User userToSave = UserTestData.getUserTransient();
        // when
        User savedUser = userRepository.save(userToSave);
        // then
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isNotNull();
    }

    @Test
    @DisplayName("Test find user by email functionality")
    public void givenEmail_whenFindByEmail_thenUserIsReturned() {
        // given
        User userToSave = UserTestData.getUserTransient();
        userRepository.save(userToSave);
        // when
        User obtainedUser = userRepository.findByEmail(userToSave.getEmail()).orElse(null);
        // then
        assertThat(obtainedUser).isNotNull();
        assertThat(obtainedUser.getEmail()).isEqualTo(userToSave.getEmail());
    }

}
