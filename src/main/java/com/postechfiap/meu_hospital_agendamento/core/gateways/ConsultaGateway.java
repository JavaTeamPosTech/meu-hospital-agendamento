package com.postechfiap.meu_hospital_agendamento.core.gateways;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConsultaGateway {

    ConsultaMedicaDomain cadastrarConsulta(ConsultaMedicaDomain consultaMedicaDomain);
    ConsultaMedicaDomain atualizarConsulta(ConsultaMedicaDomain consultaMedicaDomain);
    Optional<ConsultaMedicaDomain> buscarConsultaPorId(UUID id);
    ConsultaMedicaDomain cancelarConsulta(UUID id);
    List<ConsultaMedicaDomain> listarConsultas();
    void buscarEntidadesConsulta(UUID idMedico, UUID idPaciente, UUID idHospital);

}
