package com.escola.gestaoescolar.dto;

public record NotaResponseDTO(
        Long id,
        String alunoNome,
        String aulaAssunto,
        Double valor
) {}