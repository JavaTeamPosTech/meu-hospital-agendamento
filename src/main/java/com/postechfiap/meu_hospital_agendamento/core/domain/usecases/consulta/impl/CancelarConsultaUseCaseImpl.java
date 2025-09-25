package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.impl;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.AtualizarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.CancelarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.AtualizarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.CancelarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CancelarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.gateways.ConsultaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CancelarConsultaUseCaseImpl implements CancelarConsultaUseCase {

    private final ConsultaGateway consultaGateway;
    private final CancelarConsultaOutputPort cancelarConsultaOutputPort;


    @Override
    public ConsultaMedicaDomain execute(UUID id) {

        Optional<ConsultaMedicaDomain> consultaMedicaOption = consultaGateway.buscarConsultaPorId(id);

        if(consultaMedicaOption.isEmpty()){
            throw new RuntimeException("Consulta com ID " + id + " não encontrada para atualização.");
        }

        ConsultaMedicaDomain consultaMedicaExistente = consultaMedicaOption.get();

        ConsultaMedicaDomain consultaAtualizada = consultaGateway.cancelarConsulta(consultaMedicaExistente.getId());
        cancelarConsultaOutputPort.presentSuccess(consultaAtualizada);

        return consultaAtualizada;

    }

}
