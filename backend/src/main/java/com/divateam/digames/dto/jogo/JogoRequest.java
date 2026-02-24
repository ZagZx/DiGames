package com.divateam.digames.dto.jogo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record JogoRequest(
        @NotEmpty(message = "Nome não pode ser vazio ou nulo")
        @Min(value = 3, message = "Nome deve ter pelo menos 3 caracteres")
        String nome,

        @NotEmpty(message = "Status não pode ser vazio ou nulo")
        String status,

        @NotNull(message = "Preço não pode ser nulo")
        @DecimalMin(value = "0.0", message = "Preço não pode ser negativo")
        BigDecimal preco,

        String descricao,

        @NotEmpty(message="É necessário pelo menos um gênero")
        List<Long> generosId
) {}
