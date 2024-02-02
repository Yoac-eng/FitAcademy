package com.fitAcademy.fitAcademy.repositories;
import com.fitAcademy.fitAcademy.entities.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
}

