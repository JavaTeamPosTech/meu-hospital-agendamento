package com.postechfiap.meu_hospital_agendamento.infrastructure.api.presenters.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.CancelarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.CancelarConsultaResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class CancelarConsultaPresenter implements CancelarConsultaOutputPort {

    private CancelarConsultaResponseDTO viewModel;

    public void presentSuccess(ConsultaMedicaDomain consulta) {
        this.viewModel = new CancelarConsultaResponseDTO(
                consulta.getId(),
                consulta.getIsAtivo(),
                "Consulta cancelada com sucesso!",
                "SUCCESS"
        );
    }

    public CancelarConsultaResponseDTO getViewModel() {
        return this.viewModel;
    }

}
