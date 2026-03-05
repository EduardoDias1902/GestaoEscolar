package com.escola.gestaoescolar.dto;

import java.util.List;

public record TurmaRequestDTO(
        String nome,
        Long cursoId,
        Long professorId,
        List<Long> listaAlunoIds
) {}