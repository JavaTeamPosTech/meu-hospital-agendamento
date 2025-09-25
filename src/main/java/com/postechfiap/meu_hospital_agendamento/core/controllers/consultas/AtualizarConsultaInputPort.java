package com.postechfiap.meu_hospital_agendamento.core.controllers.consultas;

import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CadastrarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.request.AtualizarConsultaRequestDTO;

import java.util.UUID;

public interface AtualizarConsultaInputPort {
    void execute(AtualizarConsultaInputModel input);
}
