package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CancelarConsultaInputModel;

import java.util.UUID;

public interface CancelarConsultaUseCase {
    ConsultaMedicaDomain execute(UUID id);
}
