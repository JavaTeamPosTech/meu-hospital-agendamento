package com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.impl;

import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.AtualizarConsultaInputPort;
import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.CadastrarConsultaInputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.AtualizarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.CadastrarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CadastrarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.request.AtualizarConsultaRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AtualizarConsultaInputPortImpl implements AtualizarConsultaInputPort {

    private final AtualizarConsultaUseCase atualizarConsultaUseCase;

    @Override
    public void execute(AtualizarConsultaInputModel input) {
        atualizarConsultaUseCase.execute(input);
    }

}
