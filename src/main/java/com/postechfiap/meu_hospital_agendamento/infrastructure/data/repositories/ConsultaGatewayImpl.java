package com.postechfiap.meu_hospital_agendamento.infrastructure.data.repositories;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.exceptions.ResourceNotFoundException;
import com.postechfiap.meu_hospital_agendamento.core.gateways.ConsultaGateway;
import com.postechfiap.meu_hospital_agendamento.infrastructure.data.datamappers.ConsultaDataMapper;
import com.postechfiap.meu_hospital_agendamento.infrastructure.model.ConsultaMedicaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConsultaGatewayImpl implements ConsultaGateway {

    private final ConsultaRepository consultaRepository;
    private final ConsultaDataMapper consultaDataMapper;

    @Override
    public ConsultaMedicaDomain cadastrarConsulta(ConsultaMedicaDomain consultaDomain) {
        ConsultaMedicaEntity consultaEntity = consultaDataMapper.toEntity(consultaDomain);
        ConsultaMedicaEntity savedEntity = consultaRepository.save(consultaEntity);
        return consultaDataMapper.toDomain(savedEntity);
    }

    @Override
    public ConsultaMedicaDomain atualizarConsulta(ConsultaMedicaDomain consultaDomain) {
        return cadastrarConsulta(consultaDomain);
    }

    @Override
    public Optional<ConsultaMedicaDomain> buscarConsultaPorId(UUID id){
        Optional<ConsultaMedicaEntity> consultaMedicaEntityOptional = consultaRepository.findById(id);

        if (consultaMedicaEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException("Consulta com ID " + id + " não encontrada.");
        }

        return consultaMedicaEntityOptional.map(consultaDataMapper::toDomain);
    }

    @Override
    public ConsultaMedicaDomain cancelarConsulta(UUID id) {
        ConsultaMedicaEntity consultaMedicaEntity = consultaRepository.findById(id).get();
        consultaMedicaEntity.setIsAtivo(false);
        consultaRepository.save(consultaMedicaEntity);
        return consultaDataMapper.toDomain(consultaMedicaEntity);
    }

    @Override
    public List<ConsultaMedicaDomain> listarConsultas() {
        List<ConsultaMedicaEntity> consultaMedicaEntities = consultaRepository.findAll();

        return consultaMedicaEntities.stream()
                .map(consultaDataMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void buscarEntidadesConsulta(UUID medicoId, UUID pacienteId, UUID hospitalId) {
        if (!consultaRepository.existsByMedicoId(medicoId)) {
            throw new ResourceNotFoundException("Médico não encontrado: " + medicoId);
        }

        if (!consultaRepository.existsByPacienteId(pacienteId)) {
            throw new ResourceNotFoundException("Paciente não encontrado: " + pacienteId);
        }

        if (!consultaRepository.existsByHospitalId(hospitalId)) {
            throw new ResourceNotFoundException("Hospital não encontrado: " + hospitalId);
        }
    }


}
