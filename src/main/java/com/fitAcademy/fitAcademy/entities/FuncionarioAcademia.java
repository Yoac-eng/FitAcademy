package com.fitAcademy.fitAcademy.entities;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Representa um funcionário da academia, associado a um membro específico.
 */
@Entity
@Table(name = "funcionarios_academia")
@Data
@EqualsAndHashCode(of = "id")
public class FuncionarioAcademia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id", nullable = false)
    private Membro membro;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "data_de_inicio", nullable = false)
    private LocalDate dataDeInicio;
}
