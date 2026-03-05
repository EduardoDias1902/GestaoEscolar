package com.escola.gestaoescolar.dto;

public record NotaRequestDTO(
        Long alunoId,
        Long aulaId,
        Double valor
) {}