package com.postechfiap.meu_hospital_agendamento.infrastructure.api.users.security;

import com.postechfiap.meu_hospital_agendamento.core.gateways.AuthGateway;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.UserAuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthGatewayImpl {

    private final AuthGateway authGateway;

    public AuthGatewayImpl(AuthGateway authGateway) {
        this.authGateway = authGateway;
    }

    public UserAuthResponse getUserByLogin(String login, String token) {
        return authGateway.getUserByLogin(login, token);
    }
}


