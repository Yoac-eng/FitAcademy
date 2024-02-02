package com.fitAcademy.fitAcademy.controllers;
import com.fitAcademy.fitAcademy.entities.Membro;
import com.fitAcademy.fitAcademy.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membros")
public class MembroController {

    @Autowired
    private MembroService membroService;

    @GetMapping
    public ResponseEntity<List<Membro>> getAllMembros() {
        return ResponseEntity.ok(membroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membro> getMembroById(@PathVariable Long id) {
        return ResponseEntity.ok(membroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Membro> createMembro(@RequestBody Membro membro) {
        return ResponseEntity.ok(membroService.save(membro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membro> updateMembro(@PathVariable Long id, @RequestBody Membro membroDetails) {
        return ResponseEntity.ok(membroService.update(id, membroDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMembro(@PathVariable Long id) {
        membroService.delete(id);
        return ResponseEntity.ok().build();
    }
}

