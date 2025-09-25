package com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.impl;

import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.AtualizarConsultaInputPort;
import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.CancelarConsultaInputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.AtualizarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.CancelarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CancelarConsultaInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CancelarConsultaInputPortImpl implements CancelarConsultaInputPort {

    private final CancelarConsultaUseCase cancelarConsultaUseCase;

    @Override
    public void execute(UUID id) {
        cancelarConsultaUseCase.execute(id);
    }

}
