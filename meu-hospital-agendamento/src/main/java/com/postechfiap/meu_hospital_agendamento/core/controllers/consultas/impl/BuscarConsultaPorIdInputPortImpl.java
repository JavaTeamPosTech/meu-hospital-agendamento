package com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.impl;

import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.BuscarConsultaPorIdInputPort;
import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.BuscarConsultasInputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.BuscarConsultaPorIdUseCase;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.BuscarConsultasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BuscarConsultaPorIdInputPortImpl implements BuscarConsultaPorIdInputPort {

    private final BuscarConsultaPorIdUseCase buscarConsultaPorIdUseCase;

    @Override
    public void execute(UUID id) {
        buscarConsultaPorIdUseCase.execute(id);
    }

}
