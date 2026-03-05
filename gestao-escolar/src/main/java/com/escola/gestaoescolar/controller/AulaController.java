package com.escola.gestaoescolar.controller;

import com.escola.gestaoescolar.dto.AulaRequestDTO;
import com.escola.gestaoescolar.dto.AulaResponseDTO;
import com.escola.gestaoescolar.service.AulaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    private final AulaService service;

    public AulaController(AulaService service) {
        this.service = service;
    }

    @GetMapping
    public List<AulaResponseDTO> listar(){

        return service.listar();
    }

    @PostMapping
    public void criar(@RequestBody AulaRequestDTO dto){

        service.criar(dto);
    }

}