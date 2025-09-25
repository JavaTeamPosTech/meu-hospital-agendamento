package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;

import java.util.List;
import java.util.UUID;

public interface BuscarConsultaPorIdUseCase {
    ConsultaMedicaDomain execute(UUID id);
}
