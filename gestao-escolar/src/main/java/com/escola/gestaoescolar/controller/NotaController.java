package com.escola.gestaoescolar.controller;

import com.escola.gestaoescolar.dto.NotaRequestDTO;
import com.escola.gestaoescolar.dto.NotaResponseDTO;
import com.escola.gestaoescolar.service.NotaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService service;

    public NotaController(NotaService service) {
        this.service = service;
    }

    @GetMapping
    public List<NotaResponseDTO> listar(){

        return service.listar();
    }

    @PostMapping
    public void criar(@RequestBody NotaRequestDTO dto){

        service.criar(dto);
    }

}