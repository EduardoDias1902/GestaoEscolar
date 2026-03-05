package com.escola.gestaoescolar.dto;

import java.util.List;
public record CursoResponseDTO(
    Long id,
    String nome,
    String codigo,
    List<String> listaProfessores
)
{}
