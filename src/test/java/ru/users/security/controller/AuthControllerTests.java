package ru.users.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import ru.users.security.config.JwtService;
import ru.users.security.model.dto.AuthenticationResponse;
import ru.users.security.model.dto.RegistrationRequest;
import ru.users.security.service.AuthenticationService;
import ru.users.security.utils.AuthenticationResponseTestData;
import ru.users.security.utils.RegistrationRequestTestData;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AuthController.class)
public class AuthControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private AuthenticationService authenticationService;

    @Test
    @DisplayName("Test registration functionality")
    public void givenRegistrationRequest_whenRegistration_thenAuthResponseIsReturned() throws Exception {
        // given
        RegistrationRequest request = RegistrationRequestTestData.getRegistrationRequest();
        AuthenticationResponse response = AuthenticationResponseTestData.getAuthenticationResponse();

        BDDMockito.given(authenticationService.register(request))
                .willReturn(response);
        // when
        ResultActions result = mockMvc.perform(post("/api/v1/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)));
        // then
        result
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Test authentication functionality")
    public void givenAuthRequest_whenRegistration_thenAuthResponseIsReturned() throws Exception {
        // given
        RegistrationRequest request = RegistrationRequestTestData.getRegistrationRequest();
        AuthenticationResponse response = AuthenticationResponseTestData.getAuthenticationResponse();

        BDDMockito.given(authenticationService.register(request))
                .willReturn(response);
        // when
        ResultActions result = mockMvc.perform(post("/api/v1/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)));
        // then
        result
                .andDo(MockMvcResultHandlers.print());
    }


}
