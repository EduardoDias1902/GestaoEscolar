package com.escola.gestaoescolar.service;

import com.escola.gestaoescolar.dto.ProfessorRequestDTO;
import com.escola.gestaoescolar.dto.ProfessorResponseDTO;
import com.escola.gestaoescolar.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<ProfessorResponseDTO> listar() {

        return repository.listar();
    }

    public ProfessorResponseDTO buscar(Long id) {

        return repository.buscarPorId(id);
    }

    public void criar(ProfessorRequestDTO dto) {

        repository.criar(
                dto.nome(),
                dto.email(),
                dto.disciplina()
        );
    }

    public void atualizar(Long id, ProfessorRequestDTO dto) {

        repository.atualizar(
                id,
                dto.nome(),
                dto.email(),
                dto.disciplina()
        );
    }

    public void deletar(Long id) {

        repository.deletar(id);
    }

}