package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.impl;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.AtualizarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.CadastrarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.AtualizarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.exceptions.ResourceNotFoundException;
import com.postechfiap.meu_hospital_agendamento.core.gateways.ConsultaGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AtualizarConsultaUseCaseImpl implements AtualizarConsultaUseCase {

    private final ConsultaGateway consultaGateway;
    private final AtualizarConsultaOutputPort atualizarConsultaOutputPort;


    @Override
    public ConsultaMedicaDomain execute(AtualizarConsultaInputModel input) {

        Optional<ConsultaMedicaDomain> consultaMedicaOption = consultaGateway.buscarConsultaPorId(input.getId());

        if(consultaMedicaOption.isEmpty()){
            throw new ResourceNotFoundException("Consulta com ID " + input.getId() + " não encontrada.");
        }

        ConsultaMedicaDomain consultaMedicaExistente = consultaMedicaOption.get();

        if(input.getHorario().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("O horário da consulta não pode ser no passado.");
        }
        if(input.getValor() <= 0){
            throw new IllegalArgumentException("O valor da consulta deve ser maior que zero.");
        }
        if(!consultaMedicaExistente.getIsAtivo()){
            throw new IllegalArgumentException("Não é possível atualizar uma consulta cancelada.");
        }
        //Validar se as entidades existem (medico, paciente, hospital), já lança exceção se não existir
        consultaGateway.buscarEntidadesConsulta(input.getMedicoId(), input.getPacienteId(), input.getHospitalId());

        consultaMedicaExistente.setHorario(input.getHorario());
        consultaMedicaExistente.setMedicoId(input.getMedicoId());
        consultaMedicaExistente.setPacienteId(input.getPacienteId());
        consultaMedicaExistente.setValor(input.getValor());
        consultaMedicaExistente.setHospitalId(input.getHospitalId());

        ConsultaMedicaDomain consultaAtualizada = consultaGateway.atualizarConsulta(consultaMedicaExistente);
        atualizarConsultaOutputPort.presentSuccess(consultaAtualizada);

        return consultaAtualizada;

    }

}
