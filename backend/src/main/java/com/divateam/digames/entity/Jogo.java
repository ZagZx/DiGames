package com.divateam.digames.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public long getId() { return this.id; }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getStatus() {
        return this.status;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public List<Genero> getGeneros() {
        return this.generos;
    }

}
