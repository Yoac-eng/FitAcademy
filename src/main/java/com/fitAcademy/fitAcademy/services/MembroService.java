package com.fitAcademy.fitAcademy.services;
import com.fitAcademy.fitAcademy.entities.Membro;
import com.fitAcademy.fitAcademy.repositories.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    @Transactional(readOnly = true)
    public List<Membro> findAll() {
        return membroRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Membro findById(Long id) {
        Optional<Membro> membro = membroRepository.findById(id);
        if (membro.isPresent()) {
            return membro.get();
        } else {
            // Tratamento de erro ou exceção, por exemplo:
            throw new RuntimeException("Membro não encontrado");
        }
    }

    @Transactional
    public Membro save(Membro membro) {
        // Aqui você pode incluir lógica adicional antes de salvar o membro
        return membroRepository.save(membro);
    }

    @Transactional
    public Membro update(Long id, Membro membroDetails) {
        Membro membro = findById(id);
        // Atualize os campos do membro conforme necessário
        membro.setNome(membroDetails.getNome());
        membro.setEmail(membroDetails.getEmail());
        // Continue com a atualização dos outros campos...
        return membroRepository.save(membro);
    }

    @Transactional
    public void delete(Long id) {
        Membro membro = findById(id);
        membroRepository.delete(membro);
    }
}

