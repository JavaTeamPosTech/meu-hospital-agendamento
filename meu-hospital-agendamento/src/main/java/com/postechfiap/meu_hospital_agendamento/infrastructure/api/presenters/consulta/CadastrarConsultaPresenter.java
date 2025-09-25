package com.postechfiap.meu_hospital_agendamento.infrastructure.api.presenters.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.CadastrarConsultaOutputPort;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.CadastrarConsultaResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class CadastrarConsultaPresenter implements CadastrarConsultaOutputPort {

    private CadastrarConsultaResponseDTO viewModel;

    public void presentSuccess(ConsultaMedicaDomain consulta) {
        this.viewModel = new CadastrarConsultaResponseDTO(
                consulta.getId(),
                consulta.getHorario(),
                consulta.getIsRealizada(),
                consulta.getIsAtivo(),
                consulta.getMedicoId(),
                consulta.getPacienteId(),
                consulta.getValor(),
                consulta.getHospitalId(),
                "Consulta cadastrada com sucesso!",
                "SUCCESS"
        );
    }

    @Override
    public void presentError(String message) {
        this.viewModel = new CadastrarConsultaResponseDTO(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                message,
                "FAIL"
        );
    }

    public CadastrarConsultaResponseDTO getViewModel() {
        return this.viewModel;
    }

}
