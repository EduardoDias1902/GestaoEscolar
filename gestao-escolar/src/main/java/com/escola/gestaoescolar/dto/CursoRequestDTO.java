package com.escola.gestaoescolar.dto;

import java.util.List;
public record CursoRequestDTO(
    String nome,
    String codigo,
    List<Long> listaProfessorIds
) {}
