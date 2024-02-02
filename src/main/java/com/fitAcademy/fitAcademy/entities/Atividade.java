package com.fitAcademy.fitAcademy.entities;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.time.LocalTime;

/**
 * Representa uma atividade ou aula oferecida pela academia.
 */
@Entity
@Table(name = "atividades")
@Data
@EqualsAndHashCode(of = "id")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "horario_de_inicio", nullable = false)
    private LocalTime horarioDeInicio;

    @Column(name = "duracao", nullable = false)
    private Integer duracao;

    @Column(name = "capacidade")
    private Integer capacidade;
}

