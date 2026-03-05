package com.escola.gestaoescolar.dto;

import java.time.LocalDateTime;

public record AulaResponseDTO(
        Long id,
        String nomeTurma,
        LocalDateTime dataHora,
        String assunto
) {}