package com.postechfiap.meu_hospital_agendamento.core.controllers.consultas;

import java.util.UUID;

public interface BuscarConsultaPorIdInputPort {
    void execute(UUID id);
}
