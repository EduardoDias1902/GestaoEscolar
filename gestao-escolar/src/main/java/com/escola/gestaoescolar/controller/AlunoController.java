package com.escola.gestaoescolar.controller;

import com.escola.gestaoescolar.dto.AlunoRequestDTO;
import com.escola.gestaoescolar.dto.AlunoResponseDTO;
import com.escola.gestaoescolar.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AlunoResponseDTO> listar(){

        return service.listar();
    }

    @GetMapping("/{id}")
    public AlunoResponseDTO buscar(@PathVariable Long id){

        return service.buscar(id);
    }

    @PostMapping
    public void criar(@RequestBody AlunoRequestDTO dto){

        service.criar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){

        service.deletar(id);
    }

}