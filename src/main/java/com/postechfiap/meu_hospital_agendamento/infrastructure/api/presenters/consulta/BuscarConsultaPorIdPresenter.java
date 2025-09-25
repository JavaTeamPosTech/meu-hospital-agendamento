package com.postechfiap.meu_hospital_agendamento.infrastructure.api.presenters.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.BuscarConsultaPorIdOutputPort;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.BuscarConsultaResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class BuscarConsultaPorIdPresenter implements BuscarConsultaPorIdOutputPort {

    private BuscarConsultaResponseDTO viewModel;

    public void presentSuccess(ConsultaMedicaDomain consulta) {
        this.viewModel = new BuscarConsultaResponseDTO(
                        consulta.getId(),
                        consulta.getHorario(),
                        consulta.getIsAtivo(),
                        consulta.getIsRealizada(),
                        consulta.getMedicoId(),
                        consulta.getPacienteId(),
                        consulta.getValor(),
                        consulta.getHospitalId()
                );

    }

    public BuscarConsultaResponseDTO getViewModel() {
        return this.viewModel;
    }

}
