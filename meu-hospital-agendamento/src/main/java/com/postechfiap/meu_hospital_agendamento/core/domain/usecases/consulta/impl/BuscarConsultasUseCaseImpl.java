package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.impl;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.BuscarConsultasOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.CancelarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.BuscarConsultasUseCase;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.CancelarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.gateways.ConsultaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BuscarConsultasUseCaseImpl implements BuscarConsultasUseCase {

    private final ConsultaGateway consultaGateway;
    private final BuscarConsultasOutputPort buscarConsultasOutputPort;


    @Override
    public List<ConsultaMedicaDomain> execute() {

        List<ConsultaMedicaDomain> consultasMedicaDomain = consultaGateway.listarConsultas();
        buscarConsultasOutputPort.presentSuccess(consultasMedicaDomain);
        return consultasMedicaDomain;

    }

}
