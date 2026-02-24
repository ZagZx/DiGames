package com.divateam.digames.dto.genero;

import com.divateam.digames.entity.Genero;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id",
        "nome"
})
public class GeneroResponse {
    private Long id;
    private String nome;

    public GeneroResponse(Genero genero) {
        this.id = genero.getId();
        this.nome = genero.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
