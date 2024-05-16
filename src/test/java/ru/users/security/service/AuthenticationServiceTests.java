package ru.users.security.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.users.security.config.JwtService;
import ru.users.security.model.dto.AuthenticationResponse;
import ru.users.security.model.dto.RegistrationRequest;
import ru.users.security.model.entities.User;
import ru.users.security.repository.UserRepository;
import ru.users.security.utils.RegistrationRequestTestData;
import ru.users.security.utils.TokenTestData;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTests {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthenticationService serviceUnderTest;

    @Test
    @DisplayName("Test registration functionality")
    public void givenRegistrationRequest_whenRegistration_thenAuthenticationResponseIsReturned() {
        // given
        RegistrationRequest registrationRequest = RegistrationRequestTestData.getRegistrationRequest();
        String jwt = TokenTestData.getJwtToken();

        BDDMockito.given(passwordEncoder.encode(registrationRequest.getPassword()))
                .willReturn("$2a$10$gVkQVxoZkQwmf/PZPQNBM.qG3pSqsntDSeAiTrUpiluUhFMIS1CPa");

        BDDMockito.given(jwtService.generateToken(any(User.class)))
                .willReturn(jwt);
        // when
        AuthenticationResponse authenticationResponse = serviceUnderTest.register(registrationRequest);
        // then
        assertThat(authenticationResponse.getToken()).isNotNull();
    }

    @Test
    @DisplayName("Test registration with existing user functionality")
    public void test0() {}

    @Test
    @DisplayName("Test authentication functionality")
    public void test1() {}

    @Test
    @DisplayName("Test authentication with incorrect email functionality")
    public void test2() {}

    @Test
    @DisplayName("Test authentication with incorrect password functionality")
    public void test3() {}

    @Test
    @DisplayName("Test authentication with incorrect email and password functionality")
    public void test4() {}

}
