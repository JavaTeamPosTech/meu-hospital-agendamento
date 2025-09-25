package com.postechfiap.meu_hospital_agendamento.infrastructure.api.presenters.consulta;

import com.postechfiap.meu_hospital_agendamento.core.domain.entities.ConsultaMedicaDomain;
import com.postechfiap.meu_hospital_agendamento.core.domain.presenters.consulta.BuscarConsultasOutputPort;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.BuscarConsultaResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
public class BuscarConsultasPresenter implements BuscarConsultasOutputPort {

    private List<BuscarConsultaResponseDTO> viewModel;

    public void presentSuccess(List<ConsultaMedicaDomain> consultas) {
        this.viewModel = consultas.stream()
                .map(consulta -> new BuscarConsultaResponseDTO(
                        consulta.getId(),
                        consulta.getHorario(),
                        consulta.getIsAtivo(),
                        consulta.getIsRealizada(),
                        consulta.getMedicoId(),
                        consulta.getPacienteId(),
                        consulta.getValor(),
                        consulta.getHospitalId()
                )).toList();

    }

    public List<BuscarConsultaResponseDTO> getViewModel() {
        return this.viewModel;
    }

}
