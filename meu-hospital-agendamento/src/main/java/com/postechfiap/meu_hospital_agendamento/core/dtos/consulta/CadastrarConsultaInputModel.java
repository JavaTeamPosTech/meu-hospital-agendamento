package com.postechfiap.meu_hospital_agendamento.core.dtos.consulta;

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
public class CadastrarConsultaInputModel {
    private UUID medicoId;
    private UUID pacienteId;
    private Double valor;
    private UUID hospitalId;
}
