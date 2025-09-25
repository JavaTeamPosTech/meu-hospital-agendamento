package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.impl;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.CadastrarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.CadastrarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CadastrarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.gateways.AuthGateway;
import com.postechfiap.meu_hospital_agendamento.core.gateways.ConsultaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CadastrarConsultaUseCaseImpl implements CadastrarConsultaUseCase {

    private final ConsultaGateway consultaGateway;
    private final CadastrarConsultaOutputPort cadastrarConsultaOutputPort;

    @Override
    public void execute(CadastrarConsultaInputModel input) {
        ConsultaMedicaDomain consultaMedicaDomain = new ConsultaMedicaDomain(
                input.getMedicoId(),
                input.getPacienteId(),
                input.getValor(),
                input.getHospitalId()
        );

        ConsultaMedicaDomain consultaSalva = consultaGateway.cadastrarConsulta(consultaMedicaDomain);
        cadastrarConsultaOutputPort.presentSuccess(consultaSalva);
    }

}
