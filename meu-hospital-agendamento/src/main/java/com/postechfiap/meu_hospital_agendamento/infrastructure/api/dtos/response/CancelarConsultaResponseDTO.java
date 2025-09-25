package com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CancelarConsultaResponseDTO {

    private UUID id;
    private Boolean isAtivo;
    private String mensagem;
    private String status;

}
