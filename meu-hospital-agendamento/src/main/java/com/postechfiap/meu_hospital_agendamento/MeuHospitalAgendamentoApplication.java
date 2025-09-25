package com.postechfiap.meu_hospital_agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MeuHospitalAgendamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuHospitalAgendamentoApplication.class, args);
	}

}
