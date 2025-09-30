package com.postechfiap.meu_hospital_agendamento.infrastructure.api.controllers;

import com.postechfiap.meu_hospital_agendamento.core.controllers.consultas.*;
import com.postechfiap.meu_hospital_agendamento.core.gateways.AuthGateway;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.request.AtualizarConsultaRequestDTO;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.request.CadastrarConsultaRequestDTO;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.dtos.response.*;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.presenters.consulta.*;
import com.postechfiap.meu_hospital_agendamento.infrastructure.api.users.security.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/consultas-medicas")
@RestController
@RequiredArgsConstructor

//@Tag(name = "Consulta Medica")
public class ConsultaMedicaController {

    private final CadastrarConsultaInputPort cadastrarConsultaInputPort;
    private final CadastrarConsultaPresenter cadastrarConsultaPresenter;
    private final AtualizarConsultaInputPort atualizarConsultaInputPort;
    private final AtualizarConsultaPresenter atualizarConsultaPresenter;
    private final CancelarConsultaInputPort cancelarConsultaInputPort;
    private final CancelarConsultaPresenter cancelarConsultaPresenter;
    private final BuscarConsultasInputPort buscarConsultasInputPort;
    private final BuscarConsultasPresenter buscarConsultasPresenter;
    private final BuscarConsultaPorIdInputPort buscarConsultaPorIdInputPort;
    private final BuscarConsultaPorIdPresenter buscarConsultaPorIdPresenter;
    private final AuthGateway authGateway;
    private final JwtService jwtService;


//    public ConsultaMedicaController(CadastrarConsultaInputPort cadastrarConsultaInputPort, CadastrarConsultaPresenter cadastrarConsultaPresenter) {
//        this.cadastrarConsultaInputPort = cadastrarConsultaInputPort;
//        this.cadastrarConsultaPresenter = cadastrarConsultaPresenter;
//    }

//    @Operation(
//            summary = "Realiza o cadastro de um novo usuário do tipo Cliente",
//            description = "Este endpoint cria um novo usuário do tipo Cliente no sistema"
//    )
//    @PostMapping
//    public ResponseEntity<CadastrarConsultaResponseDTO> cadastrarConsulta(@RequestBody @Valid CadastrarConsultaRequestDTO cadastrarConsultaRequestDTO) {
//        cadastrarConsultaInputPort.execute(cadastrarConsultaRequestDTO.toInputModel());
//        CadastrarConsultaResponseDTO responseDTO = cadastrarConsultaPresenter.getViewModel();
//        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
//    }

    @PostMapping
    public ResponseEntity<String> cadastrarConsulta(@RequestHeader("Authorization") String authHeader, @RequestBody @Valid CadastrarConsultaRequestDTO cadastrarConsultaRequestDTO) {
        Claims claims = jwtService.getClaims(authHeader.replace("Bearer ", ""));
        String pacienteLogin = claims.getSubject();
        String emailPaciente = (String) claims.get("email");
        try{

        UserAuthResponse userAuthResponse = authGateway.getUserByLogin(pacienteLogin, authHeader);
            cadastrarConsultaInputPort.execute(cadastrarConsultaRequestDTO.toInputModel(), emailPaciente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Consulta criada pelo:" + userAuthResponse.getEmail());

        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }


        // chama outro serviço passando o mesmo token
        //UserResponse user = authClient.getUsuario(pacienteId, authHeader);

        //return "Consulta criada para " + user.getNome();




        //CadastrarConsultaResponseDTO responseDTO = cadastrarConsultaPresenter.getViewModel();
        //String login = SecurityContextHolder.getContext().getAuthentication().getName();
        //return ResponseEntity.status(HttpStatus.CREATED).body("oi");
    }

    @GetMapping
    public ResponseEntity<List<BuscarConsultaResponseDTO>> buscarConsultas() {
        buscarConsultasInputPort.execute();
        List<BuscarConsultaResponseDTO> consultas = buscarConsultasPresenter.getViewModel();
        return ResponseEntity.status(HttpStatus.OK).body(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuscarConsultaResponseDTO> buscarConsultaPorId(@PathVariable @Valid UUID id) {
        buscarConsultaPorIdInputPort.execute(id);
        BuscarConsultaResponseDTO consulta = buscarConsultaPorIdPresenter.getViewModel();
        return ResponseEntity.status(HttpStatus.OK).body(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtualizarConsultaResponseDTO> alterarConsulta(@PathVariable UUID id, @RequestBody @Valid AtualizarConsultaRequestDTO requestDTO) {
        atualizarConsultaInputPort.execute(requestDTO.toInputModel(id));
        AtualizarConsultaResponseDTO responseDTO = atualizarConsultaPresenter.getViewModel();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CancelarConsultaResponseDTO> cancelarConsulta(@PathVariable UUID id) {
        cancelarConsultaInputPort.execute(id);
        CancelarConsultaResponseDTO responseDTO = cancelarConsultaPresenter.getViewModel();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }



}
