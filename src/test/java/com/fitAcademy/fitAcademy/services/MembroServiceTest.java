package com.fitAcademy.fitAcademy.services;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fitAcademy.fitAcademy.entities.Membro;
import com.fitAcademy.fitAcademy.repositories.MembroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MembroServiceTest {

    @Mock
    private MembroRepository membroRepository;

    @InjectMocks
    private MembroService membroService;

    private Membro membro;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        membro = new Membro();
        membro.setId(1L);
        membro.setNome("Teste Membro");
        membro.setEmail("teste@membro.com");
        membro.setTipoDeMembro("Aluno");
    }

    @Test
    public void testFindAll() {
        when(membroRepository.findAll()).thenReturn(Arrays.asList(membro));
        List<Membro> result = membroService.findAll();
        assertEquals(1, result.size());
        verify(membroRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(membroRepository.findById(1L)).thenReturn(Optional.of(membro));
        Membro result = membroService.findById(1L);
        assertNotNull(result);
        assertEquals("Teste Membro", result.getNome());
    }

    @Test
    public void testSave() {
        when(membroRepository.save(any(Membro.class))).thenReturn(membro);
        Membro savedMembro = membroService.save(new Membro());
        assertNotNull(savedMembro);
        assertEquals("Teste Membro", savedMembro.getNome());
    }
}

