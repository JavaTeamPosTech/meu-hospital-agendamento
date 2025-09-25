package com.postechfiap.meu_hospital_agendamento.core.controllers.consultas;

import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CancelarConsultaInputModel;

import java.util.UUID;

public interface CancelarConsultaInputPort {
    void execute(UUID id);
}
