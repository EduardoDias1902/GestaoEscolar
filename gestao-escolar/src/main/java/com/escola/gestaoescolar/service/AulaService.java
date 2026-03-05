package com.escola.gestaoescolar.service;

import com.escola.gestaoescolar.dto.AulaRequestDTO;
import com.escola.gestaoescolar.dto.AulaResponseDTO;
import com.escola.gestaoescolar.repository.AulaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    private final AulaRepository repository;

    public AulaService(AulaRepository repository) {
        this.repository = repository;
    }

    public List<AulaResponseDTO> listar(){

        return repository.listar();
    }

    public void criar(AulaRequestDTO dto){

        repository.criar(
                dto.turmaId(),
                dto.dataHora().toString(),
                dto.assunto()
        );
    }

}