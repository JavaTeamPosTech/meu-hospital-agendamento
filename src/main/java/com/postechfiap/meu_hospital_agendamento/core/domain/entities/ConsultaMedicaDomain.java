package com.postechfiap.meu_hospital_agendamento.core.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ConsultaMedicaDomain {

    private UUID id;
    private LocalDateTime horario;
    private Boolean isRealizada;
    private Boolean isAtivo;
    private UUID medicoId;
    private UUID pacienteId;
    private Double valor;
    private UUID hospitalId;

    public ConsultaMedicaDomain(UUID id, LocalDateTime horario, Boolean isRealizada, Boolean isAtivo, UUID medicoId, UUID pacienteId, Double valor, UUID hospitalId) {
        this.id = id;
        this.horario = horario;
        this.isRealizada = isRealizada;
        this.isAtivo = isAtivo;
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.valor = valor;
        this.hospitalId = hospitalId;
    }

    public ConsultaMedicaDomain(UUID medicoId, UUID pacienteId, Double valor, UUID hospitalId) {
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.valor = valor;
        this.hospitalId = hospitalId;
    }

}
