package com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;

public interface CancelarConsultaOutputPort {
    void presentSuccess(ConsultaMedicaDomain consulta);
}
