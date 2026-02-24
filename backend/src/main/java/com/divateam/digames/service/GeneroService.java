package com.divateam.digames.service;

import com.divateam.digames.dto.genero.GeneroRequest;
import com.divateam.digames.entity.Genero;
import com.divateam.digames.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> listar() {
        return generoRepository.findAll();
    }

    public Genero criar(GeneroRequest generoRequest) {
        Genero genero = new Genero(generoRequest.nome());
        return generoRepository.save(genero);
    }
}
