package com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;

public interface AtualizarConsultaOutputPort {
    void presentSuccess(ConsultaMedicaDomain consulta);
}
