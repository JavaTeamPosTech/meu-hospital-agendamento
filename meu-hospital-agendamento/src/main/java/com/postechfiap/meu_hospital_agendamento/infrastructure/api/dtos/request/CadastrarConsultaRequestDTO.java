package com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.request;

import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CadastrarConsultaInputModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Schema(description = "DTO para requisição de cadastro de uma nova consulta médica")
public record CadastrarConsultaRequestDTO(

        @Schema(description = "Id do medico. Precisa estar preenchido.", example = "c56a4180-65aa-42ec-a945-5fd21dec0538")
        @NotNull(message = "Id é obrigatório")
        UUID medicoId,

        @Schema(description = "Id do paciente. Precisa estar preenchido.", example = "c56a4180-65aa-42ec-a945-5fd21dec0538")
        @NotNull(message = "Id é obrigatório")
        UUID pacienteId,

        @Schema(description = "Valor da consulta. Precisa estar preenchido.", example = "100.00")

        @NotNull(message = "Valor é obrigatório")
        Double valor,
        @Schema(description = "Id do hospital. Precisa estar preenchido.",
                example = "c56a4180-65aa-42ec-a945-5fd21dec0538")

        @NotNull(message = "Id é obrigatório")
        UUID hospitalId
) {


    public CadastrarConsultaInputModel toInputModel() {

        return new CadastrarConsultaInputModel(
                medicoId,
                pacienteId,
                valor,
                hospitalId
        );

//        Set<TiposComidaEnum> safePreferencias = preferenciasAlimentares != null
//                ? new HashSet<>(preferenciasAlimentares)
//                : new HashSet<>();
//        Set<AlergiaAlimentarEnum> safeAlergias = alergias != null
//                ? new HashSet<>(alergias)
//                : new HashSet<>();
//        List<EnderecoInputModel> safeEnderecos = enderecos != null
//                ? enderecos.stream().map(EnderecoRequestDTO::toInputModel).collect(Collectors.toList())
//                : new ArrayList<>();
//
//        return new CadastrarClienteInputModel(
//                nome,
//                email,
//                login,
//                senha,
//                cpf,
//                dataNascimento,
//                genero,
//                telefone,
//                safePreferencias,
//                safeAlergias,
//                metodoPagamentoPreferido,
//                notificacoesAtivas,
//                safeEnderecos
//        );
    }

}
