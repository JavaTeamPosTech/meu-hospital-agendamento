package com.postechfiap.meu_hospital_agendamento.infrastructure.api.notification;

import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.NotificacaoConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, NotificacaoConsultaDTO> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, NotificacaoConsultaDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private static final String TOPIC = "consulta-criada";

//    public void enviarMensagem(String consulta, String emailPaciente) {
//        // JSON simples
//        String mensagem = String.format("{\"consulta\":\"%s\",\"email\":\"%s\"}", consulta, emailPaciente);
//        kafkaTemplate.send(TOPIC, mensagem);
//    }

    public void enviarMensagem(NotificacaoConsultaDTO appointment) {
        System.out.println("Antes do .send: " + appointment.getPatientName());
        kafkaTemplate.send("consulta-criada", appointment);
        System.out.println("Mensagem enviada: " + appointment.getPatientName());
    }

}

