package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.impl;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.BuscarConsultaPorIdOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.BuscarConsultaPorIdUseCase;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.BuscarEntidadesConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.gateways.ConsultaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BuscarEntidadesConsultaUseCaseImpl implements BuscarEntidadesConsultaUseCase {

    private final ConsultaGateway consultaGateway;

    @Override
    public void execute(UUID idMedico, UUID idPaciente, UUID idHospital) {
        //Validar se as entidades existem, se não existir, lança exceção
        consultaGateway.buscarEntidadesConsulta(idMedico, idPaciente, idHospital);
    }

}
