package com.escola.gestaoescolar.service;

import com.escola.gestaoescolar.dto.CursoRequestDTO;
import com.escola.gestaoescolar.dto.CursoResponseDTO;
import com.escola.gestaoescolar.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public List<CursoResponseDTO> listar() {

        return repository.listar();
    }

    public CursoResponseDTO buscar(Long id) {

        return repository.buscarPorId(id);
    }

    public void criar(CursoRequestDTO dto) {

        repository.criar(
                dto.nome(),
                dto.codigo()
        );
    }

    public void atualizar(Long id, CursoRequestDTO dto) {

        repository.atualizar(
                id,
                dto.nome(),
                dto.codigo()
        );
    }

    public void deletar(Long id) {

        repository.deletar(id);
    }

}