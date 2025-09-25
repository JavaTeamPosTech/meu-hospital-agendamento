package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;

import java.util.List;

public interface BuscarConsultasUseCase {
    List<ConsultaMedicaDomain> execute();
}
