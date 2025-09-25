package com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.impl;

import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.AtualizarConsultaInputPort;
import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.BuscarConsultasInputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.AtualizarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.BuscarConsultasUseCase;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BuscarConsultasInputPortImpl implements BuscarConsultasInputPort {

    private final BuscarConsultasUseCase buscarConsultasUseCase;

    @Override
    public void execute() {
        buscarConsultasUseCase.execute();
    }

}
