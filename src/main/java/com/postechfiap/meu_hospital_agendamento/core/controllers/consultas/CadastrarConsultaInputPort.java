package com.postechfiap.meu_hospital_agendamento.core.controllers.consultas;

import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CadastrarConsultaInputModel;

public interface CadastrarConsultaInputPort {
    void execute(CadastrarConsultaInputModel input, String emailPaciente);
}
