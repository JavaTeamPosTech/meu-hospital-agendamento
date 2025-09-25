package com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;

import java.util.List;

public interface BuscarConsultaPorIdOutputPort {
    void presentSuccess(ConsultaMedicaDomain consulta);
}
