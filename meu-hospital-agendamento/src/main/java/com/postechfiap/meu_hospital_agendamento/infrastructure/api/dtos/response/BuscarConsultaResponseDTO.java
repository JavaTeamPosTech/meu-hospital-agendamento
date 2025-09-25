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
public class BuscarConsultaResponseDTO {

    private UUID id;
    private LocalDateTime horario;
    private Boolean isAtivo;
    private Boolean isRealizada;
    private UUID medicoId;
    private UUID pacienteId;
    private Double valor;
    private UUID hospitalId;
}
