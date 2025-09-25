package com.postechfiap.meu_hospital_agendamento.infrastructure.api.presenters.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.AtualizarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.AtualizarConsultaResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class AtualizarConsultaPresenter implements AtualizarConsultaOutputPort {

    private AtualizarConsultaResponseDTO viewModel;

    public void presentSuccess(ConsultaMedicaDomain consulta) {
        this.viewModel = new AtualizarConsultaResponseDTO(
                consulta.getId(),
                consulta.getHorario(),
                consulta.getIsRealizada(),
                consulta.getIsAtivo(),
                consulta.getMedicoId(),
                consulta.getPacienteId(),
                consulta.getValor(),
                consulta.getHospitalId(),
                "Consulta atualizada com sucesso!",
                "SUCCESS"
        );
    }

    public AtualizarConsultaResponseDTO getViewModel() {
        return this.viewModel;
    }

}
