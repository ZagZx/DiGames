package com.divateam.digames.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genero {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false, length=30)
    private String nome;

    @ManyToMany(mappedBy = "generos")
    private List<Jogo> jogos;

    public long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
}
