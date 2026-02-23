package com.divateam.digames.dto.jogo;

import com.divateam.digames.dto.genero.GeneroResponseDto;
import com.divateam.digames.entity.Jogo;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class JogoResponseDto {
    private Long id;
    private String nome;
    private String status;
    private String descricao;
    private BigDecimal preco;
    private List<GeneroResponseDto> generos;

    public JogoResponseDto(Jogo jogo) {
        this.id = jogo.getId();
        this.nome = jogo.getNome();
        this.status = jogo.getStatus();
        this.descricao = jogo.getDescricao();
        this.preco = jogo.getPreco();
        this.generos = jogo.getGeneros().stream().map(GeneroResponseDto::new).toList();
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

    public List<GeneroResponseDto> getGeneros() {
        return this.generos;
    }
}
