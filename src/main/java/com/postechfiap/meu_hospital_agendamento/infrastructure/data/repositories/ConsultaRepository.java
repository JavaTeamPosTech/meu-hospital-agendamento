package com.postechfiap.meu_hospital_agendamento.infrastructure.data.repositories;

import com.postechfiap.meu_hospital_agendamento.infrastructure.model.ConsultaMedicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<ConsultaMedicaEntity, UUID> {

    Boolean existsByMedicoId(UUID medicoId);
    Boolean existsByPacienteId(UUID pacienteId);
    Boolean existsByHospitalId(UUID hospitalId);

}
