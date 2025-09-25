package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta;

import java.util.UUID;

public interface BuscarEntidadesConsultaUseCase {
    void execute(UUID idMedico, UUID idPaciente, UUID idHospital);
}
