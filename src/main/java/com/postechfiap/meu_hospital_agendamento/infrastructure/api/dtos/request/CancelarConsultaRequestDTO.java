package com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.request;

import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.AtualizarConsultaInputModel;
import com.postechfiap.meu_hospital_agendamento.core.dtos.consulta.CancelarConsultaInputModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "DTO para requisição de cadastro de uma nova consulta médica")
public record CancelarConsultaRequestDTO(

//        @Schema(description = "Id da consulta. Precisa estar preenchido.", example = "c56a4180-65aa-42ec-a945-5fd21dec0538")
//        @NotNull(message = "Id é obrigatório")
//        UUID id,

//        @Schema(description = "Status da consulta. Precisa estar preenchido.", example = "false")
//        @NotNull(message = "Status é obrigatório")
//        Boolean isAtivo

) {


    public CancelarConsultaInputModel toInputModel(UUID id) {

        return new CancelarConsultaInputModel(
                id
                //isAtivo
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
