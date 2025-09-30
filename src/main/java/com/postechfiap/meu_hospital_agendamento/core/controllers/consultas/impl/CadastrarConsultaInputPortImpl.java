package com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.impl;

import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.CadastrarConsultaInputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.CadastrarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CadastrarConsultaInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarConsultaInputPortImpl implements CadastrarConsultaInputPort {

    private final CadastrarConsultaUseCase cadastrarConsultaUseCase;

    @Override
    public void execute(CadastrarConsultaInputModel inputModel, String emailPaciente) {
        cadastrarConsultaUseCase.execute(inputModel, emailPaciente);
    }

}
