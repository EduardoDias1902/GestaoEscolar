package com.escola.gestaoescolar.controller;

import com.escola.gestaoescolar.dto.ProfessorRequestDTO;
import com.escola.gestaoescolar.dto.ProfessorResponseDTO;
import com.escola.gestaoescolar.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProfessorResponseDTO> listar() {

        return service.listar();
    }

    @GetMapping("/{id}")
    public ProfessorResponseDTO buscar(@PathVariable Long id) {

        return service.buscar(id);
    }

    @PostMapping
    public void criar(@RequestBody ProfessorRequestDTO dto) {

        service.criar(dto);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id,
                          @RequestBody ProfessorRequestDTO dto) {

        service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {

        service.deletar(id);
    }

}