package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.impl;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.BuscarConsultaPorIdOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.BuscarConsultasOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.BuscarConsultaPorIdUseCase;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.BuscarConsultasUseCase;
import com.postechfiap.meu_hospital_agendamento.core.gateways.ConsultaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BuscarConsultaPorIdUseCaseImpl implements BuscarConsultaPorIdUseCase {

    private final ConsultaGateway consultaGateway;
    private final BuscarConsultaPorIdOutputPort buscarConsultaPorIdOutputPort;


    @Override
    public ConsultaMedicaDomain execute(UUID id) {
        Optional<ConsultaMedicaDomain> consultaMedicaDomain = consultaGateway.buscarConsultaPorId(id);
        ConsultaMedicaDomain consultaMedicaDomainExistente = consultaMedicaDomain.get();
        buscarConsultaPorIdOutputPort.presentSuccess(consultaMedicaDomainExistente);
        return consultaMedicaDomainExistente;

    }

}
