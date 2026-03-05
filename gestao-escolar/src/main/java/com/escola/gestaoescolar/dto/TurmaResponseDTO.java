package com.escola.gestaoescolar.dto;

import java.util.List;

public record TurmaResponseDTO(
        Long id,
        String nome,
        String nomeCurso,
        String nomeProfessor,
        List<String> listaAlunos
) {}