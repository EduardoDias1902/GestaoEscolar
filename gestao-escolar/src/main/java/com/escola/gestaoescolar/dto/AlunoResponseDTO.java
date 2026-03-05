package com.escola.gestaoescolar.dto;

import java.time.LocalDate;

public record AlunoResponseDTO(
        Long id,
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento
) {}