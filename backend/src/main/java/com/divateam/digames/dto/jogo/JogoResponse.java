package com.divateam.digames.dto.jogo;

import com.divateam.digames.dto.genero.GeneroResponse;
import com.divateam.digames.entity.Jogo;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.List;

@JsonPropertyOrder({
        "id",
        "nome",
        "status",
        "descricao",
        "preco",
        "generos"
})
public class JogoResponse {
    private Long id;
    private String nome;
    private String status;
    private String descricao;
    private BigDecimal preco;
    private List<GeneroResponse> generos;

    public JogoResponse(Jogo jogo) {
        this.id = jogo.getId();
        this.nome = jogo.getNome();
        this.status = jogo.getStatus();
        this.descricao = jogo.getDescricao();
        this.preco = jogo.getPreco();
        this.generos = jogo.getGeneros().stream().map(GeneroResponse::new).toList();
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getStatus() {
        return this.status;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public List<GeneroResponse> getGeneros() {
        return this.generos;
    }
}
