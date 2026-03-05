package com.escola.gestaoescolar.service;

import com.escola.gestaoescolar.dto.NotaRequestDTO;
import com.escola.gestaoescolar.dto.NotaResponseDTO;
import com.escola.gestaoescolar.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    private final NotaRepository repository;

    public NotaService(NotaRepository repository) {
        this.repository = repository;
    }

    public List<NotaResponseDTO> listar(){

        return repository.listar();
    }

    public void criar(NotaRequestDTO dto){

        if(dto.valor() < 0 || dto.valor() > 10){
            throw new RuntimeException("Nota inválida");
        }

        repository.criar(
                dto.alunoId(),
                dto.aulaId(),
                dto.valor()
        );
    }

}