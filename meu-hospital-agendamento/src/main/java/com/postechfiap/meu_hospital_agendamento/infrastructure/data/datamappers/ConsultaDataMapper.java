package com.postechfiap.meu_hospital_agendamento.infrastructure.data.datamappers;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.infrastructure.model.ConsultaMedicaEntity;

public interface ConsultaDataMapper {

    ConsultaMedicaEntity toEntity(ConsultaMedicaDomain domain);
    ConsultaMedicaDomain toDomain(ConsultaMedicaEntity entity);


}
