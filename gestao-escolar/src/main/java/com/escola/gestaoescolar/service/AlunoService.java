package com.escola.gestaoescolar.service;

import com.escola.gestaoescolar.dto.AlunoRequestDTO;
import com.escola.gestaoescolar.dto.AlunoResponseDTO;
import com.escola.gestaoescolar.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<AlunoResponseDTO> listar(){

        return repository.listarTodos();
    }

    public AlunoResponseDTO buscar(Long id){

        return repository.buscarPorId(id);
    }

    public void criar(AlunoRequestDTO dto){

        repository.salvar(
                dto.nome(),
                dto.email(),
                dto.matricula(),
                dto.dataNascimento().toString()
        );
    }

    public void deletar(Long id){

        repository.deletar(id);
    }

}