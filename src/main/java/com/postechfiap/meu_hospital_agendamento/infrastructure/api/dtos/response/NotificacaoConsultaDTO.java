package com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoConsultaDTO {
    private String id;
    private String patientName;
    private LocalDateTime dateTime;
}
