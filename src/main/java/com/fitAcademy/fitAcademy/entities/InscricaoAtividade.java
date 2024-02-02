package com.fitAcademy.fitAcademy.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

/**
 * Representa a inscrição de um membro em uma atividade específica da academia.
 */
@Entity
@Table(name = "inscricoes_atividades")
@Data
@EqualsAndHashCode(of = "id")
public class InscricaoAtividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_membro", nullable = false)
    private Membro membro;

    @ManyToOne
    @JoinColumn(name = "id_atividade", nullable = false)
    private Atividade atividade;

    @Column(name = "data_da_inscricao", nullable = false)
    private LocalDate dataDaInscricao;
}
