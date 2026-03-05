package com.escola.gestaoescolar.service;

import com.escola.gestaoescolar.dto.TurmaRequestDTO;
import com.escola.gestaoescolar.dto.TurmaResponseDTO;
import com.escola.gestaoescolar.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private final TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    public List<TurmaResponseDTO> listar(){

        return repository.listar();
    }

    public void criar(TurmaRequestDTO dto){

        repository.criar(
                dto.nome(),
                dto.cursoId(),
                dto.professorId()
        );
    }

}