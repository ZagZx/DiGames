package com.divateam.digames.controller;


import com.divateam.digames.entity.Genero;
import com.divateam.digames.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public List<Genero> listarGeneros() {
        return generoRepository.findAll();
    }

    @PostMapping
    public Genero criarGenero(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }
}
