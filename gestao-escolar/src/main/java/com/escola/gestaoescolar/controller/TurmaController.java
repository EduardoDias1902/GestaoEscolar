package com.escola.gestaoescolar.controller;

import com.escola.gestaoescolar.dto.TurmaRequestDTO;
import com.escola.gestaoescolar.dto.TurmaResponseDTO;
import com.escola.gestaoescolar.service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService service;

    public TurmaController(TurmaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TurmaResponseDTO> listar(){

        return service.listar();
    }

    @PostMapping
    public void criar(@RequestBody TurmaRequestDTO dto){

        service.criar(dto);
    }

}