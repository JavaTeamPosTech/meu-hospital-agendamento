package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta;

import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CadastrarConsultaInputModel;

public interface CadastrarConsultaUseCase {
    void execute(CadastrarConsultaInputModel input, String emailPaciente);
}
