package com.escola.gestaoescolar.dto;

public record ProfessorResponseDTO(
    Long id,
    String name,
    String email,
    String disciplina
) {}
