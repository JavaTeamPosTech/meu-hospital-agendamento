package com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserAuthResponse {

    private UUID id;
    private String login;
    private String email;
}
