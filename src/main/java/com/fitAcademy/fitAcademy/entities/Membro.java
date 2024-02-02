package com.fitAcademy.fitAcademy.entities;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Representa um membro da academia, que pode ser um aluno ou funcionário da universidade.
 */
@Entity
@Table(name = "membros")
@Data
@EqualsAndHashCode(of = "id")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "tipo_de_membro", nullable = false)
    private String tipoDeMembro;

    @Column(name = "numero_de_matricula", unique = true)
    private String numeroDeMatricula;

    @Column(name = "data_de_inscricao", nullable = false)
    private LocalDate dataDeInscricao;
}

