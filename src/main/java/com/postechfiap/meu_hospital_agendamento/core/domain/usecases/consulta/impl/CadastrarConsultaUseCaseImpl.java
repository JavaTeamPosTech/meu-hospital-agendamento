package com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.impl;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.CadastrarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.core.domain.usecases.consulta.CadastrarConsultaUseCase;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CadastrarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.gateways.AuthGateway;
import com.postechfiap.meu_hospital_agendamento.core.gateways.ConsultaGateway;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.NotificacaoConsultaDTO;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.notification.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class CadastrarConsultaUseCaseImpl implements CadastrarConsultaUseCase {

    private final ConsultaGateway consultaGateway;
    private final CadastrarConsultaOutputPort cadastrarConsultaOutputPort;
    private final KafkaProducerService kafkaProducerService;;

    @Override
    public void execute(CadastrarConsultaInputModel input, String emailPaciente) {
        ConsultaMedicaDomain consultaMedicaDomain = new ConsultaMedicaDomain(
                input.getMedicoId(),
                input.getPacienteId(),
                input.getValor(),
                input.getHospitalId()
        );
        ConsultaMedicaDomain consultaSalva = consultaGateway.cadastrarConsulta(consultaMedicaDomain);
        NotificacaoConsultaDTO consultaDTO = new NotificacaoConsultaDTO(
                "1",
                "Rafael",
                LocalDateTime.now()
        );
        System.out.println("Tentando enviar mensagem para o Kafka...");
        kafkaProducerService.enviarMensagem(consultaDTO);
        cadastrarConsultaOutputPort.presentSuccess(consultaSalva);
    }

}
