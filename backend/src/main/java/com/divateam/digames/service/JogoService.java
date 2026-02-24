package com.divateam.digames.service;

import com.divateam.digames.dto.jogo.JogoRequest;
import com.divateam.digames.entity.Genero;
import com.divateam.digames.entity.Jogo;
import com.divateam.digames.repository.GeneroRepository;
import com.divateam.digames.repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {
    private final JogoRepository jogoRepository;
    private final GeneroRepository generoRepository;

    public JogoService(JogoRepository jogoRepository, GeneroRepository generoRepository) {
        this.jogoRepository = jogoRepository;
        this.generoRepository = generoRepository;
    }

    public List<Jogo> listar() {
        return jogoRepository.findAll();
    }

    public Jogo criar(JogoRequest jogoRequest) {
        List<Genero> generos = generoRepository.findAllById(jogoRequest.generosId());

        Jogo jogo = new Jogo(
                jogoRequest.nome(),
                jogoRequest.status(),
                jogoRequest.preco(),
                jogoRequest.descricao(),
                generos
        );

        return jogoRepository.save(jogo);
    }
}
