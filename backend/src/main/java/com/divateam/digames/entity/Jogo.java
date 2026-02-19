package com.divateam.digames.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Lob
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "jogo_genero",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Genero> generos;

    public Jogo() {

    }

    public Jogo(String nome, String status, BigDecimal preco, String descricao, List<Genero> generos) {
        this.nome = nome;
        this.status = status;
        this.preco = preco;
        this.descricao = descricao;
        this.generos = generos;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Genero> getGeneros() {
        return this.generos;
    }
    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
}
