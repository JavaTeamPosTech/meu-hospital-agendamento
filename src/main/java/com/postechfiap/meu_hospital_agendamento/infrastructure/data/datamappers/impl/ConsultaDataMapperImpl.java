package com.postechfiap.meu_hospital_agendamento.infrastructure.data.datamappers.impl;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.infrastructure.data.datamappers.ConsultaDataMapper;
import com.postechfiap.meu_hospital_agendamento.infrastructure.model.ConsultaMedicaEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ConsultaDataMapperImpl implements ConsultaDataMapper {

    @Override
    public ConsultaMedicaEntity toEntity(ConsultaMedicaDomain domain) {
     if(domain == null) return null;

        ConsultaMedicaEntity entity = new ConsultaMedicaEntity(
            domain.getId(),
            LocalDateTime.now(),
            false,
                true,
                domain.getMedicoId(),
            domain.getPacienteId(),
            domain.getValor(),
            domain.getHospitalId()
        );

        return entity;
    }

    @Override
    public ConsultaMedicaDomain toDomain(ConsultaMedicaEntity entity) {
        if(entity == null) return null;

        ConsultaMedicaDomain domain = new ConsultaMedicaDomain(
                entity.getId(),
                entity.getHorario(),
                entity.getIsRealizada(),
                entity.getIsAtivo(),
                entity.getMedicoId(),
                entity.getPacienteId(),
                entity.getValor(),
                entity.getHospitalId()
        );

        return domain;
    }


}
