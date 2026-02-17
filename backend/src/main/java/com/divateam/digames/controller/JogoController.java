package com.divateam.digames.controller;

import com.divateam.digames.entity.Jogo;
import com.divateam.digames.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {
    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping
    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }

    @PostMapping
    public Jogo criarJogo(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }
}
