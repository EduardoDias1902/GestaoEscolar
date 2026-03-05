package com.escola.gestaoescolar.dto;

import java.time.LocalDateTime;

public record AulaRequestDTO(
        Long turmaId,
        LocalDateTime dataHora,
        String assunto
) {}