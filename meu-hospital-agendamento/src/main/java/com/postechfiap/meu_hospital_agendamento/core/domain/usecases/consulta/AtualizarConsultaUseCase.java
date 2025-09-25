package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CadastrarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.request.AtualizarConsultaRequestDTO;

import java.util.UUID;

public interface AtualizarConsultaUseCase {
    ConsultaMedicaDomain execute(AtualizarConsultaInputModel input);
}
