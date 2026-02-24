package com.divateam.digames.dto.genero;

import jakarta.validation.constraints.NotEmpty;


public record GeneroRequest(
        @NotEmpty
        String nome
) {}
