package com.postechfiap.meu_hospital_agendamento.core.gateways;

import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.UserAuthResponse;
import io.jsonwebtoken.Claims;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authClient", url = "${auth.service.url}")
public interface AuthGateway {

    @GetMapping("/usuarios/{login}")
    UserAuthResponse getUserByLogin(@PathVariable("login") String login,
                                    @RequestHeader("Authorization") String token);
}

