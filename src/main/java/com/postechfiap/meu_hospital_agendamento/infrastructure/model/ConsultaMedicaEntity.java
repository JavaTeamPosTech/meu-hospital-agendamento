package com.postechfiap.meu_hospital_agendamento.infrastructure.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "consultas_medicas")
//@PrimaryKeyJoinColumn(name = "id")
public class ConsultaMedicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private LocalDateTime horario;
    @Column(name = "is_realizada", nullable = false)
    private Boolean isRealizada = false;

    @Column(name = "is_ativo", nullable = false)
    private Boolean isAtivo = false;

    @Column(name = "medico_id", nullable = false)
    private UUID medicoId;

    @Column(name = "paciente_id", nullable = false)
    private UUID pacienteId;
    private Double valor;
    @Column(name = "hospital_id", nullable = false)
    private UUID hospitalId;


}